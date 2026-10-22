package o5;

import Y8.j;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.view.C3016y;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherRedirectActivity;
import h8.C4148a;
import java.util.Arrays;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0017\u001a\u00020\u000b*\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lo5/a;", "", "<init>", "()V", "Landroid/content/Intent;", "intent", "", Const.INTENT_KEY_UMID, "(Landroid/content/Intent;)Z", "from", "to", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Intent;Landroid/content/Intent;)V", "Landroid/app/Activity;", "activity", "Lcom/stepos/ailauncher/chat/view/y;", "agentSpaceView", Const.INTENT_KEY_PKGNAME, "(Landroid/app/Activity;Landroid/content/Intent;Lcom/stepos/ailauncher/chat/view/y;)V", "Landroid/os/ResultReceiver;", "", "msg", "c", "(Landroid/os/ResultReceiver;Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: o5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5006a {
    public static final C5006a INSTANCE = new C5006a();
    private static final String TAG = "ChatExternalLaunchHandler";

    public final void a(Intent from, Intent to) {
        Bundle extras;
        p.i(to, "to");
        if (d(from)) {
            to.setAction(AppAutherRedirectActivity.ACTION_OPEN_CHAT);
            if (from == null || (extras = from.getExtras()) == null) {
                return;
            }
            to.putExtras(extras);
        }
    }

    public final void b(Activity activity, Intent intent, C3016y agentSpaceView) {
        Object objB;
        p.i(activity, "activity");
        p.i(agentSpaceView, "agentSpaceView");
        if (intent != null && p.d(intent.getAction(), AppAutherRedirectActivity.ACTION_OPEN_CHAT)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b((ResultReceiver) intent.getParcelableExtra("extra_result_receiver", ResultReceiver.class));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t(TAG, "parse ResultReceiver failed; continue without callback", thE, false, 8, null);
            }
            boolean zG = Result.g(objB);
            Object obj = objB;
            if (zG) {
                obj = null;
            }
            ResultReceiver resultReceiver = (ResultReceiver) obj;
            try {
                String strA = d.INSTANCE.a(activity);
                if (strA != null) {
                    y yVar = y.f34840a;
                    String str = String.format("dispatch rejected: %s", Arrays.copyOf(new Object[]{strA}, 1));
                    p.h(str, "format(...)");
                    C4148a.u(TAG, str, false, 4, null);
                    INSTANCE.c(resultReceiver, strA);
                } else {
                    ChatLaunchPayload chatLaunchPayloadA = ChatLaunchPayload.INSTANCE.a(intent);
                    if (chatLaunchPayloadA.e()) {
                        c(resultReceiver, "empty payload");
                    } else {
                        agentSpaceView.c0(chatLaunchPayloadA, resultReceiver);
                    }
                }
            } catch (Throwable th2) {
                C4148a.g(TAG, "dispatch failed", th2, false, 8, null);
                String message = th2.getMessage();
                if (message == null) {
                    message = "internal error";
                }
                c(resultReceiver, message);
            }
        }
    }

    public final void c(ResultReceiver resultReceiver, String str) {
        if (resultReceiver != null) {
            resultReceiver.send(1, x0.c.a(j.a("key_message", str)));
        }
    }

    public final boolean d(Intent intent) {
        return p.d(intent != null ? intent.getAction() : null, AppAutherRedirectActivity.ACTION_OPEN_CHAT);
    }
}
