package com.android.server.pm;

import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.UserHandle;
import android.util.ArrayMap;
import com.android.internal.pm.pkg.component.ParsedComponent;
import com.android.server.pm.pkg.AndroidPackage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public class PackageProperty {
    private ArrayMap<String, ArrayMap<String, ArrayList<PackageManager.Property>>> mActivityProperties;
    private ArrayMap<String, ArrayMap<String, ArrayList<PackageManager.Property>>> mApplicationProperties;
    private ArrayMap<String, ArrayMap<String, ArrayList<PackageManager.Property>>> mProviderProperties;
    private ArrayMap<String, ArrayMap<String, ArrayList<PackageManager.Property>>> mReceiverProperties;
    private ArrayMap<String, ArrayMap<String, ArrayList<PackageManager.Property>>> mServiceProperties;

    public PackageProperty() {
    }

    public PackageManager.Property getProperty(String propertyName, String packageName, String className) {
        if (className != null) goto L6;
        return getApplicationProperty(propertyName, packageName);
    L6:
        return getComponentProperty(propertyName, packageName, className);
    }

    public List<PackageManager.Property> queryProperty(String propertyName, int componentType, Predicate<String> filter) {
        if (componentType != 5) goto L6;
        ArrayMap<String, ArrayMap<String, ArrayList<PackageManager.Property>>> propertyMap = this.mApplicationProperties;
    L19:
        if (propertyMap != null) goto L21;
        return null;
    L21:
        ArrayMap<String, ArrayList<PackageManager.Property>> packagePropertyMap = propertyMap.get(propertyName);
        if (packagePropertyMap != null) goto L24;
        return null;
    L24:
        Binder.getCallingUid();
        UserHandle.getCallingUserId();
        int mapSize = packagePropertyMap.size();
        List<PackageManager.Property> result = new ArrayList(mapSize);
        int i = 0;
    L25:
        if (i >= mapSize) goto L32;
        String packageName = packagePropertyMap.keyAt(i);
        if (filter.test(packageName) == true) goto L30;
        result.addAll(packagePropertyMap.valueAt(i));
    L30:
        i = i + 1;
        goto L25
    L32:
        return result;
    L6:
        if (componentType != 1) goto L9;
        propertyMap = this.mActivityProperties;
        goto L19
    L9:
        if (componentType != 4) goto L12;
        propertyMap = this.mProviderProperties;
        goto L19
    L12:
        if (componentType != 2) goto L15;
        propertyMap = this.mReceiverProperties;
        goto L19
    L15:
        if (componentType != 3) goto L17;
        propertyMap = this.mServiceProperties;
        goto L19
    L17:
        propertyMap = null;
        goto L19
    }

    void addAllProperties(AndroidPackage pkg) {
        this.mApplicationProperties = addProperties(pkg.getProperties(), this.mApplicationProperties);
        this.mActivityProperties = addComponentProperties(pkg.getActivities(), this.mActivityProperties);
        this.mProviderProperties = addComponentProperties(pkg.getProviders(), this.mProviderProperties);
        this.mReceiverProperties = addComponentProperties(pkg.getReceivers(), this.mReceiverProperties);
        this.mServiceProperties = addComponentProperties(pkg.getServices(), this.mServiceProperties);
    }

    void removeAllProperties(AndroidPackage pkg) {
        this.mApplicationProperties = removeProperties(pkg.getProperties(), this.mApplicationProperties);
        this.mActivityProperties = removeComponentProperties(pkg.getActivities(), this.mActivityProperties);
        this.mProviderProperties = removeComponentProperties(pkg.getProviders(), this.mProviderProperties);
        this.mReceiverProperties = removeComponentProperties(pkg.getReceivers(), this.mReceiverProperties);
        this.mServiceProperties = removeComponentProperties(pkg.getServices(), this.mServiceProperties);
    }

    private static <T extends ParsedComponent> ArrayMap<String, ArrayMap<String, ArrayList<PackageManager.Property>>> addComponentProperties(List<T> components, ArrayMap<String, ArrayMap<String, ArrayList<PackageManager.Property>>> propertyCollection) {
        ArrayMap<String, ArrayMap<String, ArrayList<PackageManager.Property>>> returnCollection = propertyCollection;
        int componentsSize = components.size();
        int i = 0;
    L3:
        if (i >= componentsSize) goto L10;
        Map<String, PackageManager.Property> properties = components.get(i).getProperties();
        if (properties.size() == 0) goto L8;
        returnCollection = addProperties(properties, returnCollection);
    L8:
        i = i + 1;
        goto L3
    L10:
        return returnCollection;
    }

    private static ArrayMap<String, ArrayMap<String, ArrayList<PackageManager.Property>>> addProperties(Map<String, PackageManager.Property> properties, ArrayMap<String, ArrayMap<String, ArrayList<PackageManager.Property>>> propertyCollection) {
        if (properties.size() != 0) goto L5;
        return propertyCollection;
    L5:
        if (propertyCollection != null) goto L7;
        ArrayMap<String, ArrayMap<String, ArrayList<PackageManager.Property>>> returnCollection = new ArrayMap(10);
    L8:
        Iterator<PackageManager.Property> iter = properties.values().iterator();
    L10:
        if (iter.hasNext() == false) goto L18;
        PackageManager.Property property = iter.next();
        String propertyName = property.getName();
        String packageName = property.getPackageName();
        ArrayMap<String, ArrayList<PackageManager.Property>> propertyMap = returnCollection.get(propertyName);
        if (propertyMap != null) goto L14;
        propertyMap = new ArrayMap();
        returnCollection.put(propertyName, propertyMap);
    L14:
        ArrayList<PackageManager.Property> packageProperties = propertyMap.get(packageName);
        if (packageProperties != null) goto L17;
        packageProperties = new ArrayList(properties.size());
        propertyMap.put(packageName, packageProperties);
    L17:
        packageProperties.add(property);
        goto L10
    L18:
        return returnCollection;
    L7:
        returnCollection = propertyCollection;
        goto L8
    }

    private static <T extends ParsedComponent> ArrayMap<String, ArrayMap<String, ArrayList<PackageManager.Property>>> removeComponentProperties(List<T> components, ArrayMap<String, ArrayMap<String, ArrayList<PackageManager.Property>>> propertyCollection) {
        ArrayMap<String, ArrayMap<String, ArrayList<PackageManager.Property>>> returnCollection = propertyCollection;
        int componentsSize = components.size();
        int i = 0;
    L3:
        if (returnCollection == null) goto L10;
        if (i >= componentsSize) goto L10;
        Map<String, PackageManager.Property> properties = components.get(i).getProperties();
        if (properties.size() == 0) goto L9;
        returnCollection = removeProperties(properties, returnCollection);
    L9:
        i = i + 1;
    L10:
        return returnCollection;
    }

    private static ArrayMap<String, ArrayMap<String, ArrayList<PackageManager.Property>>> removeProperties(Map<String, PackageManager.Property> properties, ArrayMap<String, ArrayMap<String, ArrayList<PackageManager.Property>>> propertyCollection) {
        if (propertyCollection != null) goto L5;
        return null;
    L5:
        Iterator<PackageManager.Property> iter = properties.values().iterator();
    L7:
        if (iter.hasNext() == false) goto L22;
        PackageManager.Property property = iter.next();
        String propertyName = property.getName();
        String packageName = property.getPackageName();
        ArrayMap<String, ArrayList<PackageManager.Property>> propertyMap = propertyCollection.get(propertyName);
        if (propertyMap == null) goto L7;
        ArrayList<PackageManager.Property> packageProperties = propertyMap.get(packageName);
        if (packageProperties == null) goto L7;
        packageProperties.remove(property);
        if (packageProperties.size() != 0) goto L18;
        propertyMap.remove(packageName);
    L18:
        if (propertyMap.size() != 0) goto L7;
        propertyCollection.remove(propertyName);
        goto L7
    L22:
        if (propertyCollection.size() != 0) goto L24;
        return null;
    L24:
        return propertyCollection;
    }

    private static PackageManager.Property getProperty(String propertyName, String packageName, String className, ArrayMap<String, ArrayMap<String, ArrayList<PackageManager.Property>>> propertyMap) {
        ArrayMap<String, ArrayList<PackageManager.Property>> packagePropertyMap = propertyMap.get(propertyName);
        if (packagePropertyMap != null) goto L5;
        return null;
    L5:
        List<PackageManager.Property> propertyList = packagePropertyMap.get(packageName);
        if (propertyList != null) goto L8;
        return null;
    L8:
        int i = propertyList.size() - 1;
    L9:
        if (i < 0) goto L15;
        PackageManager.Property property = propertyList.get(i);
        if (Objects.equals(className, property.getClassName()) == true) goto L12;
        i = i - 1;
        goto L9
    L12:
        return property;
    L15:
        return null;
    }

    private PackageManager.Property getComponentProperty(String propertyName, String packageName, String className) {
        PackageManager.Property property = null;
        if (0 == 0) goto L5;
    L7:
        if (property == null) goto L9;
    L11:
        if (property == null) goto L13;
    L15:
        if (property == null) goto L17;
        return property;
    L17:
        if (this.mServiceProperties != null) goto L19;
        return property;
    L19:
        return getProperty(propertyName, packageName, className, this.mServiceProperties);
    L13:
        if (this.mReceiverProperties == null) goto L15;
        property = getProperty(propertyName, packageName, className, this.mReceiverProperties);
        goto L15
    L9:
        if (this.mProviderProperties == null) goto L11;
        property = getProperty(propertyName, packageName, className, this.mProviderProperties);
        goto L11
    L5:
        if (this.mActivityProperties == null) goto L7;
        property = getProperty(propertyName, packageName, className, this.mActivityProperties);
        goto L7
    }

    private PackageManager.Property getApplicationProperty(String propertyName, String packageName) {
        if (this.mApplicationProperties == null) goto L5;
        ArrayMap<String, ArrayList<PackageManager.Property>> packagePropertyMap = this.mApplicationProperties.get(propertyName);
    L6:
        if (packagePropertyMap != null) goto L8;
        return null;
    L8:
        List<PackageManager.Property> propertyList = packagePropertyMap.get(packageName);
        if (propertyList != null) goto L12;
        return null;
    L12:
        return propertyList.get(0);
    L5:
        packagePropertyMap = null;
        goto L6
    }
}
