package A6;

import B9.C0194v;
import B9.C0195w;
import B9.Q;
import B9.S;
import C7.r;
import C9.AbstractC0200b;
import C9.t;
import D7.v;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import androidx.core.content.ContextCompat;
import com.mdisdk.observer.AppDiedInfo;
import com.mdisdk.observer.DisplayObserverManager;
import com.mdisdk.observer.ForegroundAppInfo;
import com.mdisdk.observer.VisibleWindowInfo;
import com.stepos.ability.R;
import com.stepos.ability.mcpserver.McpServerInit;
import com.stepos.ability.voicewakeup.setting.VoiceWakeSettingActivity;
import com.stepos.ability.voicewakeup.training.TrainingListenEffect;
import com.stepos.agentframework.adapter.bff.BffClient;
import com.stepos.agentframework.adapter.bff.Option;
import com.stepos.widget.dialog.StepOSAlertDialogLayout;
import com.zyql.agentfront.IMessageBridge;
import com.zyql.agentfront.bean.CancelMessageRequest;
import j9.AbstractC1607a;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Pair;
import kotlin.text.Regex;
import kotlinx.serialization.json.internal.JsonException;
import z9.C2201c;

/* loaded from: classes3.dex */
public final /* synthetic */ class i implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f148a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ i(int i, Object obj, Object obj2) {
        this.f148a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // S7.a
    public final Object invoke() throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        String[] strArrNames;
        boolean z10 = true;
        int i = 0;
        switch (this.f148a) {
            case 0:
                StepOSAlertDialogLayout stepOSAlertDialogLayout = (StepOSAlertDialogLayout) this.b;
                Context context = (Context) this.c;
                int i6 = StepOSAlertDialogLayout.p;
                Drawable drawable = ContextCompat.getDrawable(context, R.drawable.stepos_bg_dialog);
                stepOSAlertDialogLayout.b = drawable != null ? drawable.mutate() : null;
                stepOSAlertDialogLayout.c();
                return r.f317a;
            case 1:
                C0195w c0195w = (C0195w) this.b;
                String str = (String) this.c;
                Enum[] enumArr = c0195w.f262a;
                C0194v c0194v = new C0194v(str, enumArr.length);
                for (Enum r02 : enumArr) {
                    c0194v.j(r02.name(), false);
                }
                return c0194v;
            case 2:
                return z2.l.l((String) this.b, z9.k.f, new z9.g[0], new Q((S) this.c, i));
            case 3:
                ((Context) this.c).getContentResolver().unregisterContentObserver((C4.d) this.b);
                return r.f317a;
            case 4:
                ((C4.f) this.b).b.removeOnModeChangedListener((C4.e) this.c);
                return r.f317a;
            case 5:
                z9.g gVar = (z9.g) this.b;
                AbstractC0200b abstractC0200b = (AbstractC0200b) this.c;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                C9.i iVar = abstractC0200b.f321a;
                D9.j.n(abstractC0200b, gVar);
                int iD = gVar.d();
                for (int i10 = 0; i10 < iD; i10++) {
                    List listF = gVar.f(i10);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : listF) {
                        if (obj instanceof t) {
                            arrayList.add(obj);
                        }
                    }
                    t tVar = (t) v.W0(arrayList);
                    if (tVar != null && (strArrNames = tVar.names()) != null) {
                        for (String str2 : strArrNames) {
                            String str3 = kotlin.jvm.internal.k.b(gVar.getKind(), z9.j.c) ? "enum value" : "property";
                            if (linkedHashMap.containsKey(str2)) {
                                String message = "The suggested name '" + str2 + "' for " + str3 + ' ' + gVar.e(i10) + " is already one of the names for " + str3 + ' ' + gVar.e(((Number) kotlin.collections.a.N(str2, linkedHashMap)).intValue()) + " in " + gVar;
                                kotlin.jvm.internal.k.f(message, "message");
                                throw new JsonException(message);
                            }
                            linkedHashMap.put(str2, Integer.valueOf(i10));
                        }
                    }
                }
                return linkedHashMap.isEmpty() ? kotlin.collections.a.M() : linkedHashMap;
            case 6:
                VoiceWakeSettingActivity voiceWakeSettingActivity = (VoiceWakeSettingActivity) this.b;
                S7.a aVar = (S7.a) this.c;
                int i11 = VoiceWakeSettingActivity.f3343j;
                Log.i("VoiceWakeSettingActivity", "permission dialog allowed userId=".concat(H3.b.g));
                com.stepos.ability.voicewakeup.a.b(voiceWakeSettingActivity, H3.b.g, true);
                aVar.invoke();
                return r.f317a;
            case 7:
                S7.a aVar2 = (S7.a) this.b;
                H7.h hVar = (H7.h) this.c;
                if (!((Boolean) aVar2.invoke()).booleanValue() && kotlinx.coroutines.a.k(hVar)) {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            case 8:
                ((com.stepos.ability.voicewakeup.training.b) this.b).f3395a.removeCallbacks((H4.r) this.c);
                return r.f317a;
            case 9:
                com.stepos.ability.voicewakeup.training.c cVar = (com.stepos.ability.voicewakeup.training.c) this.b;
                if (cVar.g == ((TrainingListenEffect) this.c) && cVar.i) {
                    cVar.h = null;
                    cVar.a();
                }
                return r.f317a;
            case 10:
                return ComposerImpl.insertMovableContentGuarded$lambda$41$lambda$40$lambda$39$lambda$38$lambda$37$lambda$36$lambda$35((ComposerImpl) this.b, (MovableContentStateReference) this.c);
            case 11:
                return Recomposer.performRecompose$lambda$68$lambda$67((MutableScatterSet) this.b, (ControlledComposition) this.c);
            case 12:
                return CompositionErrorContextImpl.attachComposeStackTrace$lambda$0((CompositionErrorContextImpl) this.b, this.c);
            case 13:
                return BffClient.client_delegate$lambda$0((Option) this.b, (BffClient) this.c);
            case 14:
                com.zyql.agentfront.sdk.client.b bVar = (com.zyql.agentfront.sdk.client.b) this.b;
                CancelMessageRequest cancelMessageRequest = (CancelMessageRequest) this.c;
                IMessageBridge iMessageBridge = bVar.f5289a;
                com.zyql.agentfront.sdk.client.b.f4243s.b("AgentFrontClient", "[API] cancel message:" + cancelMessageRequest.getMessageId() + " end. result:" + (iMessageBridge != null ? iMessageBridge.cancelMessage(cancelMessageRequest) : null));
                return r.f317a;
            case 15:
                return McpServerInit.init$lambda$0((McpServerInit) this.b, (com.stepos.ability.mcpserver.endpoint.a) this.c);
            case 16:
                H3.b bVar2 = (H3.b) this.b;
                String str4 = (String) this.c;
                String strA = bVar2.a();
                if (strA.length() == 0) {
                    Log.w("McpServerModule", "account token empty; ide-ability verify may answer 99999 (not logged in)");
                }
                String nonce = String.valueOf(System.currentTimeMillis());
                kotlin.jvm.internal.k.f(nonce, "nonce");
                String strN = B7.a.n("studio", nonce, nonce, str4);
                Mac mac = Mac.getInstance("HmacSHA256");
                Charset charset = AbstractC1607a.f4778a;
                byte[] bytes = str4.getBytes(charset);
                kotlin.jvm.internal.k.e(bytes, "getBytes(...)");
                mac.init(new SecretKeySpec(bytes, "HmacSHA256"));
                byte[] bytes2 = strN.getBytes(charset);
                kotlin.jvm.internal.k.e(bytes2, "getBytes(...)");
                byte[] bArrDoFinal = mac.doFinal(bytes2);
                kotlin.jvm.internal.k.e(bArrDoFinal, "doFinal(...)");
                StringBuilder sb = new StringBuilder();
                sb.append((CharSequence) "");
                int length = bArrDoFinal.length;
                int i12 = 0;
                while (i < length) {
                    byte b = bArrDoFinal[i];
                    i12++;
                    if (i12 > 1) {
                        sb.append((CharSequence) "");
                    }
                    sb.append((CharSequence) String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1)));
                    i++;
                }
                sb.append((CharSequence) "");
                return kotlin.collections.a.T(kotlin.collections.a.R(new Pair("zy-app-id", "studio"), new Pair("zy-nonce", nonce), new Pair("zy-timestamp", nonce), new Pair("zy-sign", sb.toString()), new Pair("zy-client-type", "Android")), strA.length() == 0 ? kotlin.collections.a.M() : B7.a.x("Authorization", strA));
            case 17:
                return ((Regex) this.b).b((CharSequence) this.c);
            case 18:
                return DisplayObserverManager.notifyAppDied$lambda$4((List) this.b, (AppDiedInfo) this.c);
            case 19:
                return DisplayObserverManager.notifyForegroundAppChanged$lambda$0((List) this.b, (ForegroundAppInfo) this.c);
            case 20:
                return DisplayObserverManager.notifyVisibleWindowChanged$lambda$2((List) this.b, (VisibleWindowInfo) this.c);
            default:
                return z2.l.l((String) this.b, C2201c.d, new z9.g[0], new x9.d((x9.e) this.c, i));
        }
    }

    public /* synthetic */ i(Context context, C4.d dVar) {
        this.f148a = 3;
        this.c = context;
        this.b = dVar;
    }
}
