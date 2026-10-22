package com.android.server.infra;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArraySet;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class SecureSettingsServiceNameResolver extends ServiceNameBaseResolver {
    private static final char COMPONENT_NAME_SEPARATOR = ':';
    private final String mProperty;
    private final TextUtils.SimpleStringSplitter mStringColonSplitter;

    public SecureSettingsServiceNameResolver(Context context, String property) {
        this(context, property, false);
    }

    public SecureSettingsServiceNameResolver(Context context, String property, boolean isMultiple) {
        super(context, isMultiple);
        this.mStringColonSplitter = new TextUtils.SimpleStringSplitter(COMPONENT_NAME_SEPARATOR);
        this.mProperty = property;
    }

    @Override // com.android.server.infra.ServiceNameResolver
    public void dumpShort(PrintWriter pw) {
        pw.print("SecureSettingsServiceNamer: prop=");
        pw.print(this.mProperty);
    }

    @Override // com.android.server.infra.ServiceNameBaseResolver, com.android.server.infra.ServiceNameResolver
    public void dumpShort(PrintWriter pw, int userId) {
        pw.print("defaultService=");
        pw.print(getDefaultServiceName(userId));
    }

    @Override // com.android.server.infra.ServiceNameBaseResolver
    public String toString() {
        return "SecureSettingsServiceNameResolver[" + this.mProperty + "]";
    }

    @Override // com.android.server.infra.ServiceNameBaseResolver
    public String[] readServiceNameList(int userId) {
        return parseColonDelimitedServiceNames(Settings.Secure.getStringForUser(this.mContext.getContentResolver(), this.mProperty, userId));
    }

    @Override // com.android.server.infra.ServiceNameBaseResolver
    public String readServiceName(int userId) {
        return Settings.Secure.getStringForUser(this.mContext.getContentResolver(), this.mProperty, userId);
    }

    @Override // com.android.server.infra.ServiceNameResolver
    public void setServiceNameList(List<String> componentNames, int userId) {
        if (componentNames != null) goto L4;
    L12:
        Settings.Secure.putStringForUser(this.mContext.getContentResolver(), this.mProperty, null, userId);
        return;
    L4:
        if (componentNames.isEmpty() == true) goto L12;
        StringBuilder builder = new StringBuilder(componentNames.get(0));
        int i = 1;
    L8:
        if (i >= componentNames.size()) goto L10;
        builder.append(COMPONENT_NAME_SEPARATOR);
        builder.append(componentNames.get(i));
        i = i + 1;
        goto L8
    L10:
        Settings.Secure.putStringForUser(this.mContext.getContentResolver(), this.mProperty, builder.toString(), userId);
    }

    private String[] parseColonDelimitedServiceNames(String serviceNames) {
        Set<String> delimitedServices = new ArraySet();
        if (TextUtils.isEmpty(serviceNames) == true) goto L11;
        TextUtils.SimpleStringSplitter splitter = this.mStringColonSplitter;
        splitter.setString(serviceNames);
    L6:
        if (splitter.hasNext() == false) goto L11;
        String str = splitter.next();
        if (TextUtils.isEmpty(str) == true) goto L6;
        delimitedServices.add(str);
    L11:
        String[] delimitedServicesArray = new String[delimitedServices.size()];
        return (String[]) delimitedServices.toArray(delimitedServicesArray);
    }
}
