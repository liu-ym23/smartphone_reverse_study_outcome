package com.stepos.ailauncher.express.orchestrator;

import K5.ExpressApp;
import K5.SceneNode;
import L5.b;
import La.H;
import M5.c;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Y8.t;
import Z8.C1172u;
import Z8.F;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.express.capsule.h;
import com.stepos.ailauncher.express.net.AmooExpressData;
import com.stepos.ailauncher.express.net.AmooExpressRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.d;
import kotlinx.coroutines.g;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 -2\u00020\u0001:\u0001.B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ6\u0010\u0015\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000fH\u0082@¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0017\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000fH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\fJ\u0019\u0010\u001d\u001a\u00020\n2\b\b\u0001\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010 \u001a\u00020\u001f*\u00020\u0010H\u0002¢\u0006\u0004\b \u0010!R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\"R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/stepos/ailauncher/express/orchestrator/ExpressOrchestrator;", "", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/express/capsule/h;", "capsule", "<init>", "(Landroid/content/Context;Lcom/stepos/ailauncher/express/capsule/h;)V", "", c.REEDIT_INSTRUCTION, "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)V", "f", "()V", "", "LK5/d;", "sceneNodes", "focused", "Lcom/stepos/ailauncher/express/net/b$a;", "edited", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/List;LK5/d;Ljava/util/List;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LK5/d;Ljava/util/List;)Ljava/lang/String;", "text", Const.INTENT_KEY_BACKGROUND_COMMAND, "", "resId", "l", "(I)V", "Lcom/stepos/ailauncher/express/net/e$a;", "k", "(LK5/d;)Lcom/stepos/ailauncher/express/net/e$a;", "Landroid/content/Context;", "Lcom/stepos/ailauncher/express/capsule/h;", "LUa/M;", "scope", "LUa/M;", "Lkotlinx/coroutines/g;", "currentJob", "Lkotlinx/coroutines/g;", "", "runGeneration", "J", "Companion", Const.INTENT_KEY_APIKEY, "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExpressOrchestrator {
    private static final String CLIP_LABEL = "Amoo express";
    private static final String TAG = "ExpressOrchestrator";
    private final h capsule;
    private final Context context;
    private g currentJob;
    private long runGeneration;
    private final M scope;

    public ExpressOrchestrator(Context context, h capsule) {
        p.i(context, "context");
        p.i(capsule, "capsule");
        this.context = context;
        this.capsule = capsule;
        this.scope = d.a(L0.b(null, 1, null).plus(Y.c()));
    }

    public final void f() {
        this.runGeneration++;
        g gVar = this.currentJob;
        if (gVar != null) {
            g.Y0(gVar, null, 1, null);
        }
        this.currentJob = null;
        this.capsule.t();
    }

    public final void g(String text) {
        Object systemService = this.context.getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            clipboardManager.setPrimaryClip(ClipData.newPlainText(CLIP_LABEL, text));
            l(R$string.express_clipboard_toast);
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(java.util.List<K5.SceneNode> r10, K5.SceneNode r11, java.util.List<com.stepos.ailauncher.express.net.AmooExpressData.Edited> r12, e9.InterfaceC4014c<? super Y8.t> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.express.orchestrator.ExpressOrchestrator.h(java.util.List, K5.d, java.util.List, e9.c):java.lang.Object");
    }

    public final String i(SceneNode focused, List<AmooExpressData.Edited> edited) {
        Object obj;
        Iterator<T> it = edited.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (p.d(((AmooExpressData.Edited) next).getScene(), focused != null ? focused.getScene() : null)) {
                obj = next;
                break;
            }
        }
        AmooExpressData.Edited edited2 = (AmooExpressData.Edited) obj;
        if (edited2 == null) {
            edited2 = (AmooExpressData.Edited) F.q0(edited);
        }
        return com.stepos.ailauncher.express.net.c.a(edited2);
    }

    public final void j(String instruction) {
        p.i(instruction, "instruction");
        b bVar = b.INSTANCE;
        String strC = bVar.c();
        String strF = bVar.f();
        ExpressApp expressAppB = K5.b.INSTANCE.b(strC);
        K5.c mapper = expressAppB != null ? expressAppB.getMapper() : null;
        if (strC != null && strF != null && mapper != null) {
            long j10 = this.runGeneration + 1;
            this.runGeneration = j10;
            g gVar = this.currentJob;
            if (gVar != null) {
                g.Y0(gVar, null, 1, null);
            }
            this.currentJob = C1060i.d(this.scope, null, null, new ExpressOrchestrator$run$1(this, strC, mapper, strF, j10, instruction, null), 3, null);
            return;
        }
        Log.w(TAG, "run skipped: pkg=" + strC + " trackId=" + strF + " mapper=" + mapper);
    }

    public final AmooExpressRequest.Edit k(SceneNode sceneNode) {
        List listE = C1172u.e(sceneNode.getNode().getText());
        ArrayList arrayList = new ArrayList();
        for (Object obj : listE) {
            if (!H.x0((String) obj)) {
                arrayList.add(obj);
            }
        }
        return new AmooExpressRequest.Edit(sceneNode.getScene(), arrayList, null, 4, null);
    }

    public final void l(int resId) {
        Toast.makeText(this.context, resId, 0).show();
    }
}
