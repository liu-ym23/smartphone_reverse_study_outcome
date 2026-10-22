package a0;

import ai.onnxruntime.OrtProviderOptions;
import ai.onnxruntime.providers.OrtCUDAProviderOptions;
import ai.onnxruntime.providers.OrtTensorRTProviderOptions;
import android.util.Log;
import androidx.datastore.preferences.protobuf.CodedOutputStream;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import kotlin.Result;
import kotlin.c;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.i;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements OrtProviderOptions.OrtProviderSupplier, PolicySdk.PolicySdkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2a;

    public /* synthetic */ a(int i10) {
        this.f2a = i10;
    }

    public static void A(String str, String str2, String str3) {
        Log.w(str3, str + str2);
    }

    public static int a(float f8, int i10, int i11) {
        return (Float.hashCode(f8) + i10) * i11;
    }

    public static int b(int i10, int i11, int i12) {
        return CodedOutputStream.s(i10) + i11 + i12;
    }

    public static int c(int i10, long j10, int i11) {
        return (Long.hashCode(j10) + i10) * i11;
    }

    public static String d(long j10, String str, String str2, StringBuilder sb2) {
        sb2.append(str);
        sb2.append(j10);
        sb2.append(str2);
        return sb2.toString();
    }

    public static String e(RecyclerView recyclerView, StringBuilder sb2) {
        sb2.append(recyclerView.exceptionLabel());
        return sb2.toString();
    }

    public static String f(String str, int i10, int i11, String str2) {
        return str + i10 + str2 + i11;
    }

    public static String g(String str, int i10, String str2, String str3) {
        return str + i10 + str2 + str3;
    }

    public static String h(String str, long j10, String str2, String str3) {
        return str + j10 + str2 + str3;
    }

    public static String i(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String j(String str, String str2) {
        return str + str2;
    }

    public static String k(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String l(StringBuilder sb2, int i10, char c9) {
        sb2.append(i10);
        sb2.append(c9);
        return sb2.toString();
    }

    public static String m(StringBuilder sb2, boolean z, String str) {
        sb2.append(z);
        sb2.append(str);
        return sb2.toString();
    }

    public static String n(d dVar) {
        return i.a(dVar.getClass()).c();
    }

    public static StringBuilder o(String str, long j10, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(j10);
        sb2.append(str2);
        sb2.append(str3);
        return sb2;
    }

    public static StringBuilder p(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str2);
        return sb2;
    }

    public static StringBuilder q(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(str2);
        sb2.append(str3);
        return sb2;
    }

    public static Result.Failure r(String str) {
        return c.a(new IllegalStateException(str));
    }

    public static void s(long j10, String str, String str2, StringBuilder sb2) {
        sb2.append(str);
        sb2.append(j10);
        sb2.append(str2);
    }

    public static void t(Integer num, MapBuilder mapBuilder, String str) {
        mapBuilder.put(str, new Integer(num.intValue()));
    }

    public static void u(String str, int i10, String str2, String str3, String str4) {
        Log.w(str4, str + i10 + str2 + str3);
    }

    public static void v(String str, String str2, String str3) {
        Log.d(str3, str + str2);
    }

    public static void w(String str, String str2, String str3, String str4, String str5) {
        Log.w(str5, str + str2 + str3 + str4);
    }

    public static void x(StringBuilder sb2, String str, LogModule logModule, String str2) {
        sb2.append(str);
        AIEngineLogger.w(logModule, str2, sb2.toString());
    }

    public static void y(String str, String str2, String str3) {
        Log.i(str3, str + str2);
    }

    public static void z(StringBuilder sb2, String str, LogModule logModule, String str2) {
        sb2.append(str);
        AIEngineLogger.i(logModule, str2, sb2.toString());
    }

    @Override // ai.onnxruntime.OrtProviderOptions.OrtProviderSupplier
    public long create() {
        switch (this.f2a) {
            case 8:
                return OrtCUDAProviderOptions.lambda$new$0();
            default:
                return OrtTensorRTProviderOptions.lambda$new$0();
        }
    }

    @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
    public void getResult(PolicySdkResultBean policySdkResultBean) {
        boolean z = (policySdkResultBean == null || policySdkResultBean.getCode() != 0 || policySdkResultBean.getPolicyNewest()) ? false : true;
        AIEngineLogger.d(LogModule.SERVICE, "PolicyOpener", "getOnlinePolicyMethod pp code=" + (policySdkResultBean != null ? Integer.valueOf(policySdkResultBean.getCode()) : null) + " newest=" + (policySdkResultBean != null ? Boolean.valueOf(policySdkResultBean.getPolicyNewest()) : null) + " → open " + (z ? "online" : "local"));
    }
}
