package ai.onnxruntime;

import ad.i;
import android.content.Context;
import android.util.Log;
import androidx.datastore.preferences.protobuf.CodedOutputStream;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.core.common.cloud.CloudInferenceClient;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import com.stepos.policy.sdk.net.PolicySdkRetrofitCreator;
import d2.i;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import okhttp3.internal.connection.d;
import okhttp3.logging.HttpLoggingInterceptor;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements TextInputLayout.f, i.c, ConfirmDecisionBus.StageListener, HttpLoggingInterceptor.a, i.e {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f182g;

    public /* synthetic */ a(int i10) {
        this.f182g = i10;
    }

    public static int d(int i10, int i11, int i12) {
        return (Integer.hashCode(i10) + i11) * i12;
    }

    public static int e(int i10, int i11, int i12, int i13) {
        return CodedOutputStream.u(i10) + i11 + i12 + i13;
    }

    public static int f(int i10, int i11, boolean z) {
        return (Boolean.hashCode(z) + i10) * i11;
    }

    public static String g(int i10, String str, String str2) {
        return str + i10 + str2;
    }

    public static String h(long j10, String str, String str2) {
        return str + j10 + str2;
    }

    public static String i(String str, int i10, String str2, String str3, String str4) {
        return str + str2 + str3 + i10 + str4;
    }

    public static String j(String str, int i10, StringBuilder sb2) {
        sb2.append(i10);
        sb2.append(str);
        return sb2.toString();
    }

    public static String k(String str, String str2) {
        return str + str2;
    }

    public static String l(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static String m(StringBuilder sb2, long j10, String str) {
        sb2.append(j10);
        sb2.append(str);
        return sb2.toString();
    }

    public static String n(StringBuilder sb2, String str, char c9) {
        sb2.append(str);
        sb2.append(c9);
        return sb2.toString();
    }

    public static String o(StringBuilder sb2, String str, String str2) {
        sb2.append(str);
        sb2.append(str2);
        return sb2.toString();
    }

    public static String p(StringBuilder sb2, String str, String str2, String str3) {
        sb2.append(str);
        sb2.append(str2);
        sb2.append(str3);
        return sb2.toString();
    }

    public static StringBuilder q(long j10, String str, String str2) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(j10);
        sb2.append(str2);
        return sb2;
    }

    public static StringBuilder r(long j10, String str, String str2, int i10) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(j10);
        sb2.append(str2);
        sb2.append(i10);
        return sb2;
    }

    public static StringBuilder s(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str4);
        sb2.append(str5);
        return sb2;
    }

    public static Result.Failure t(String str) {
        return c.a(new IllegalArgumentException(str));
    }

    public static void u(long j10, String str, String str2, StringBuilder sb2) {
        sb2.append(j10);
        sb2.append(str);
        sb2.append(str2);
    }

    public static void v(Context context, int i10, String str, LinkedHashMap linkedHashMap, String str2) {
        String string = context.getString(i10);
        g.e(string, str);
        linkedHashMap.put(str2, string);
    }

    public static void w(String str, String str2, LogModule logModule, String str3) {
        AIEngineLogger.w(logModule, str3, str + str2);
    }

    public static void x(String str, String str2, String str3, String str4) {
        Log.w(str4, str + str2 + str3);
    }

    public static void y(StringBuilder sb2, String str, String str2) {
        sb2.append(str);
        Log.i(str2, sb2.toString());
    }

    public static void z(StringBuilder sb2, String str, String str2, String str3, String str4) {
        sb2.append(str);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str4);
    }

    @Override // d2.i.e
    public void a(i.d dVar, d2.i iVar) {
        switch (this.f182g) {
            case 27:
                dVar.f(iVar);
                break;
            default:
                dVar.b();
                break;
        }
    }

    @Override // ad.i.c
    public ad.i b(d dVar) {
        return CloudInferenceClient.client_delegate$lambda$8$lambda$7(dVar);
    }

    @Override // okhttp3.logging.HttpLoggingInterceptor.a
    public void c(String str) {
        PolicySdkRetrofitCreator.buildRetrofit$lambda$0(str);
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.StageListener
    public void onStage(ConfirmDecisionBus.SubStage subStage) {
        switch (this.f182g) {
            case 23:
                g.f(subStage, "it");
                break;
            default:
                g.f(subStage, "it");
                break;
        }
    }
}
