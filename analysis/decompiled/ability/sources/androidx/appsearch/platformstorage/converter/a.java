package androidx.appsearch.platformstorage.converter;

import android.app.Notification;
import android.app.appfunctions.ExecuteAppFunctionRequest;
import android.app.appsearch.AppSearchSchema;
import android.app.appsearch.EmbeddingVector;
import android.os.flagging.AconfigPackage;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ void A() {
    }

    public static /* bridge */ /* synthetic */ void B(Object obj) {
    }

    public static /* synthetic */ Notification.ProgressStyle c() {
        return new Notification.ProgressStyle();
    }

    public static /* bridge */ /* synthetic */ ExecuteAppFunctionRequest d(Object obj) {
        return (ExecuteAppFunctionRequest) obj;
    }

    public static /* synthetic */ AppSearchSchema.EmbeddingPropertyConfig.Builder f(String str) {
        return new AppSearchSchema.EmbeddingPropertyConfig.Builder(str);
    }

    public static /* bridge */ /* synthetic */ AppSearchSchema.EmbeddingPropertyConfig h(AppSearchSchema.PropertyConfig propertyConfig) {
        return (AppSearchSchema.EmbeddingPropertyConfig) propertyConfig;
    }

    public static /* synthetic */ EmbeddingVector i(float[] fArr, String str) {
        return new EmbeddingVector(fArr, str);
    }

    public static /* bridge */ /* synthetic */ AconfigPackage k(Object obj) {
        return (AconfigPackage) obj;
    }

    public static /* bridge */ /* synthetic */ Class m() {
        return Notification.ProgressStyle.class;
    }

    public static /* synthetic */ void q() {
    }

    public static /* bridge */ /* synthetic */ void v(Object obj) {
    }

    public static /* bridge */ /* synthetic */ boolean w(AppSearchSchema.PropertyConfig propertyConfig) {
        return propertyConfig instanceof AppSearchSchema.EmbeddingPropertyConfig;
    }
}
