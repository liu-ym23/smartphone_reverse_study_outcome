package androidx.appfunctions.metadata;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import androidx.appfunctions.internal.Constants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import org.xmlpull.v1.XmlPullParserException;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0002J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionPackageMetadata;", "", "packageName", "", "appFunctions", "", "Landroidx/appfunctions/metadata/AppFunctionMetadata;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/util/List;)V", "getPackageName", "()Ljava/lang/String;", "getAppFunctions", "()Ljava/util/List;", "equals", "", "other", "hashCode", "", "toString", "resolveAppFunctionAppMetadata", "Landroidx/appfunctions/metadata/AppFunctionAppMetadata;", "context", "Landroid/content/Context;", "getXmlAttributeValue", "xmlParser", "Landroid/content/res/XmlResourceParser;", "attributeName", "getXmlAttributeResourceValue", "Companion", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppFunctionPackageMetadata {
    private static final String APP_METADATA_APPFUNCTIONS_LIBRARY_ATTRIBUTE_NAMESPACE = "http://schemas.android.com/apk/androidx.appfunctions";
    private static final String APP_METADATA_ATTRIBUTE_NAMESPACE = "http://schemas.android.com/apk/res-auto";
    private static final String APP_METADATA_XML_PROPERTY = "android.app.appfunctions.app_metadata";
    private static final Companion Companion = new Companion(null);
    private static final String DESCRIPTION_ATTRIBUTE_NAME = "description";
    private static final String DISPLAY_DESCRIPTION_ATTRIBUTE_NAME = "displayDescription";
    private final List<AppFunctionMetadata> appFunctions;
    private final String packageName;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionPackageMetadata$Companion;", "", AppAgent.CONSTRUCT, "()V", "APP_METADATA_XML_PROPERTY", "", "APP_METADATA_ATTRIBUTE_NAMESPACE", "APP_METADATA_APPFUNCTIONS_LIBRARY_ATTRIBUTE_NAMESPACE", "DISPLAY_DESCRIPTION_ATTRIBUTE_NAME", "DESCRIPTION_ATTRIBUTE_NAME", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public AppFunctionPackageMetadata(String packageName, List<AppFunctionMetadata> appFunctions) {
        k.f(packageName, "packageName");
        k.f(appFunctions, "appFunctions");
        this.packageName = packageName;
        this.appFunctions = appFunctions;
    }

    private final int getXmlAttributeResourceValue(XmlResourceParser xmlParser, String attributeName) {
        int attributeResourceValue = xmlParser.getAttributeResourceValue(APP_METADATA_ATTRIBUTE_NAMESPACE, attributeName, 0);
        return attributeResourceValue == 0 ? xmlParser.getAttributeResourceValue(APP_METADATA_APPFUNCTIONS_LIBRARY_ATTRIBUTE_NAMESPACE, attributeName, 0) : attributeResourceValue;
    }

    private final String getXmlAttributeValue(XmlResourceParser xmlParser, String attributeName) {
        String attributeValue = xmlParser.getAttributeValue(APP_METADATA_ATTRIBUTE_NAMESPACE, attributeName);
        return attributeValue == null ? xmlParser.getAttributeValue(APP_METADATA_APPFUNCTIONS_LIBRARY_ATTRIBUTE_NAMESPACE, attributeName) : attributeValue;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!AppFunctionPackageMetadata.class.equals(other != null ? other.getClass() : null)) {
            return false;
        }
        k.d(other, "null cannot be cast to non-null type androidx.appfunctions.metadata.AppFunctionPackageMetadata");
        AppFunctionPackageMetadata appFunctionPackageMetadata = (AppFunctionPackageMetadata) other;
        return k.b(this.packageName, appFunctionPackageMetadata.packageName) && k.b(this.appFunctions, appFunctionPackageMetadata.appFunctions);
    }

    public final List<AppFunctionMetadata> getAppFunctions() {
        return this.appFunctions;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return this.appFunctions.hashCode() + (this.packageName.hashCode() * 31);
    }

    @RequiresApi(31)
    @WorkerThread
    public final AppFunctionAppMetadata resolveAppFunctionAppMetadata(Context context) throws XmlPullParserException, Resources.NotFoundException, PackageManager.NameNotFoundException, IOException {
        k.f(context, "context");
        PackageManager packageManager = context.getPackageManager();
        try {
            int resourceId = packageManager.getProperty(APP_METADATA_XML_PROPERTY, this.packageName).getResourceId();
            if (resourceId == 0) {
                return null;
            }
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.packageName, 0);
            k.e(applicationInfo, "getApplicationInfo(...)");
            Resources resourcesForApplication = packageManager.getResourcesForApplication(applicationInfo, context.getResources().getConfiguration());
            k.e(resourcesForApplication, "getResourcesForApplication(...)");
            XmlResourceParser xml = resourcesForApplication.getXml(resourceId);
            k.e(xml, "getXml(...)");
            while (xml.getEventType() != 2) {
                xml.next();
                if (xml.getEventType() == 1) {
                    return null;
                }
            }
            String xmlAttributeValue = getXmlAttributeValue(xml, DESCRIPTION_ATTRIBUTE_NAME);
            int xmlAttributeResourceValue = getXmlAttributeResourceValue(xml, DISPLAY_DESCRIPTION_ATTRIBUTE_NAME);
            String string = xmlAttributeResourceValue != 0 ? resourcesForApplication.getString(xmlAttributeResourceValue) : getXmlAttributeValue(xml, DISPLAY_DESCRIPTION_ATTRIBUTE_NAME);
            if (xmlAttributeValue == null) {
                xmlAttributeValue = "";
            }
            if (string == null) {
                string = "";
            }
            return new AppFunctionAppMetadata(xmlAttributeValue, string);
        } catch (Exception e) {
            Log.d(Constants.APP_FUNCTIONS_TAG, "Encountered an error while resolving app metadata for package: " + this.packageName + '.', e);
            return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppFunctionPackageMetadata(packageName='");
        sb.append(this.packageName);
        sb.append("', appFunctions=");
        return B7.a.r(sb, this.appFunctions, ')');
    }
}
