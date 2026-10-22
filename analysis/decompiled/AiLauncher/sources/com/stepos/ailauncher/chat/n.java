package com.stepos.ailauncher.chat;

import Ua.C1060i;
import Z8.C1173v;
import Z8.M;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.view.S;
import androidx.activity.result.ActivityResult;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import d.AbstractC3936b;
import d.InterfaceC3935a;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001?B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u0014J\u000f\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010 \u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\"2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b%\u0010&J+\u0010+\u001a\u00020\u00102\u0006\u0010(\u001a\u00020'2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00100)H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b.\u0010/R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00100R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00101R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00102R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u00103\u001a\u0004\b\t\u0010\u001c\"\u0004\b4\u00105R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00106R\u0016\u00107\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00103R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u000209088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u000209088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010;R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u000209088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010;¨\u0006@"}, d2 = {"Lcom/stepos/ailauncher/chat/n;", "Lcom/stepos/ailauncher/chat/c;", "Landroidx/appcompat/app/d;", "activity", "Lcom/stepos/ailauncher/chat/PickFileMediatorViewModel;", "viewModel", "Lcom/stepos/ailauncher/chat/f;", "interceptor", "", "isFromFakeMode", "", "resultKeyBase", "<init>", "(Landroidx/appcompat/app/d;Lcom/stepos/ailauncher/chat/PickFileMediatorViewModel;Lcom/stepos/ailauncher/chat/f;ZLjava/lang/String;)V", "", "maxCount", "LY8/t;", "u", "(I)V", "s", "()V", "Landroid/net/Uri;", "uri", "r", "(Landroid/net/Uri;)V", "q", "release", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Z", "Landroid/content/Intent;", "data", "resultAction", "n", "(Landroid/content/Intent;Ljava/lang/String;)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/content/Intent;)Ljava/util/List;", "k", "(Landroid/content/Intent;)V", "Lcom/stepos/ailauncher/chat/MainPagePreLoadAction;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "Lkotlin/Function1;", "decorateIntentBlock", "x", "(Lcom/stepos/ailauncher/chat/MainPagePreLoadAction;Lp9/l;)V", "Landroidx/core/app/c;", "w", "()Landroidx/core/app/c;", "Landroidx/appcompat/app/d;", "Lcom/stepos/ailauncher/chat/PickFileMediatorViewModel;", "Lcom/stepos/ailauncher/chat/f;", "Z", "y", "(Z)V", "Ljava/lang/String;", "released", "Ld/b;", "Lcom/stepos/ailauncher/chat/d;", "pickImgResultLauncher", "Ld/b;", "pickDocResultLauncher", "editImgWithAILauncher", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class n implements c {
    private static final String TAG = "PickFileMediator";
    private final androidx.appcompat.app.d activity;
    private final AbstractC3936b<PickFileArgs> editImgWithAILauncher;
    private final f interceptor;
    private boolean isFromFakeMode;
    private final AbstractC3936b<PickFileArgs> pickDocResultLauncher;
    private final AbstractC3936b<PickFileArgs> pickImgResultLauncher;
    private boolean released;
    private final String resultKeyBase;
    private final PickFileMediatorViewModel viewModel;
    private static final AtomicInteger keySeq = new AtomicInteger(0);

    public n(androidx.appcompat.app.d activity, PickFileMediatorViewModel viewModel, f interceptor, boolean z10, String resultKeyBase) {
        kotlin.jvm.internal.p.i(activity, "activity");
        kotlin.jvm.internal.p.i(viewModel, "viewModel");
        kotlin.jvm.internal.p.i(interceptor, "interceptor");
        kotlin.jvm.internal.p.i(resultKeyBase, "resultKeyBase");
        this.activity = activity;
        this.viewModel = viewModel;
        this.interceptor = interceptor;
        this.isFromFakeMode = z10;
        this.resultKeyBase = resultKeyBase;
        this.pickImgResultLauncher = activity.getActivityResultRegistry().o(resultKeyBase + "_img", new x(), new InterfaceC3935a() { // from class: com.stepos.ailauncher.chat.g
            @Override // d.InterfaceC3935a
            public final void a(Object obj) {
                n.v(this.f25368a, (ActivityResult) obj);
            }
        });
        this.pickDocResultLauncher = activity.getActivityResultRegistry().o(resultKeyBase + "_doc", new x(), new InterfaceC3935a() { // from class: com.stepos.ailauncher.chat.h
            @Override // d.InterfaceC3935a
            public final void a(Object obj) {
                n.t(this.f25369a, (ActivityResult) obj);
            }
        });
        this.editImgWithAILauncher = activity.getActivityResultRegistry().o(resultKeyBase + "_edit", new x(), new InterfaceC3935a() { // from class: com.stepos.ailauncher.chat.i
            @Override // d.InterfaceC3935a
            public final void a(Object obj) {
                n.i(this.f25370a, (ActivityResult) obj);
            }
        });
    }

    public static final void i(n nVar, ActivityResult activityResult) {
        kotlin.jvm.internal.p.i(activityResult, "activityResult");
        nVar.interceptor.a();
        if (activityResult.getResultCode() == 0) {
            nVar.interceptor.c();
            C1060i.d(S.a(nVar.viewModel), null, null, new PickFileMediator$ifCancelThenBreak$1(null), 3, null);
        }
        nVar.n(activityResult.getData(), "com.stepos.voiceassistant.ACTION.IMG_PROCESS_RESULT");
    }

    public static final Y8.t l(n nVar, boolean z10) {
        nVar.interceptor.d(z10);
        return Y8.t.f7040a;
    }

    public static final Y8.t m(n nVar, MainPagePreLoadAction model, InterfaceC5074l decorateIntentBlock) {
        kotlin.jvm.internal.p.i(model, "model");
        kotlin.jvm.internal.p.i(decorateIntentBlock, "decorateIntentBlock");
        nVar.x(model, decorateIntentBlock);
        return Y8.t.f7040a;
    }

    public static final Y8.t o(n nVar) {
        nVar.interceptor.d(false);
        return Y8.t.f7040a;
    }

    public static final Y8.t p(n nVar, MainPagePreLoadAction model, InterfaceC5074l decorateIntentBlock) {
        kotlin.jvm.internal.p.i(model, "model");
        kotlin.jvm.internal.p.i(decorateIntentBlock, "decorateIntentBlock");
        nVar.x(model, decorateIntentBlock);
        return Y8.t.f7040a;
    }

    public static final void t(n nVar, ActivityResult activityResult) {
        kotlin.jvm.internal.p.i(activityResult, "activityResult");
        nVar.interceptor.a();
        if (activityResult.getResultCode() == 0) {
            nVar.interceptor.c();
            C1060i.d(S.a(nVar.viewModel), null, null, new PickFileMediator$ifCancelThenBreak$1(null), 3, null);
        }
        nVar.k(activityResult.getData());
    }

    public static final void v(n nVar, ActivityResult activityResult) {
        kotlin.jvm.internal.p.i(activityResult, "activityResult");
        nVar.interceptor.a();
        if (activityResult.getResultCode() == 0) {
            nVar.interceptor.c();
            C1060i.d(S.a(nVar.viewModel), null, null, new PickFileMediator$ifCancelThenBreak$1(null), 3, null);
        }
        nVar.n(activityResult.getData(), "com.stepos.voiceassistant.ACTION.PICK_IMG");
    }

    public final boolean h() {
        if (this.released) {
            return false;
        }
        if (!this.activity.isFinishing() && !this.activity.isDestroyed()) {
            return true;
        }
        C4148a.u(TAG, "Activity is finishing or destroyed, skip launch", false, 4, null);
        return false;
    }

    public final List<Uri> j(Intent data) {
        if (data == null) {
            return C1173v.m();
        }
        ClipData clipData = data.getClipData();
        if (clipData == null || clipData.getItemCount() <= 0) {
            return C1173v.q(data.getData());
        }
        C5680i c5680iS = C5685n.s(0, clipData.getItemCount());
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = c5680iS.iterator();
        while (it.hasNext()) {
            Uri uri = clipData.getItemAt(((M) it).nextInt()).getUri();
            if (uri != null) {
                arrayList.add(uri);
            }
        }
        return arrayList;
    }

    public final void k(Intent data) {
        Uri data2 = data != null ? data.getData() : null;
        if (data2 == null) {
            this.interceptor.b();
        } else {
            this.viewModel.k(data2, this.isFromFakeMode, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.l
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return n.l(this.f25490a, ((Boolean) obj).booleanValue());
                }
            }, new p9.p() { // from class: com.stepos.ailauncher.chat.m
                @Override // p9.p
                public final Object invoke(Object obj, Object obj2) {
                    return n.m(this.f25530a, (MainPagePreLoadAction) obj, (InterfaceC5074l) obj2);
                }
            });
        }
    }

    public final void n(Intent data, String resultAction) {
        List<Uri> listJ = j(data);
        if (listJ.isEmpty()) {
            this.interceptor.b();
        } else {
            this.viewModel.l(listJ, resultAction, this.isFromFakeMode, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.j
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return n.o(this.f25488a);
                }
            }, new p9.p() { // from class: com.stepos.ailauncher.chat.k
                @Override // p9.p
                public final Object invoke(Object obj, Object obj2) {
                    return n.p(this.f25489a, (MainPagePreLoadAction) obj, (InterfaceC5074l) obj2);
                }
            });
        }
    }

    public void q(Uri uri) {
        kotlin.jvm.internal.p.i(uri, "uri");
        if (h()) {
            this.editImgWithAILauncher.b(new PickFileArgs(PickFileType.TYPE_AI_EXPAND_IMAGE, uri, 0, 4, null), w());
        }
    }

    public void r(Uri uri) {
        kotlin.jvm.internal.p.i(uri, "uri");
        if (h()) {
            this.editImgWithAILauncher.b(new PickFileArgs(PickFileType.TYPE_ERASER_IMAGE, uri, 0, 4, null), w());
        }
    }

    @Override // com.stepos.ailauncher.chat.c
    public void release() {
        this.released = true;
        this.pickImgResultLauncher.c();
        this.pickDocResultLauncher.c();
        this.editImgWithAILauncher.c();
    }

    public void s() {
        if (h()) {
            this.pickDocResultLauncher.b(new PickFileArgs(PickFileType.TYPE_DOC, null, 0, 6, null), w());
        }
    }

    public void u(int maxCount) {
        if (h()) {
            this.pickImgResultLauncher.b(new PickFileArgs(PickFileType.TYPE_IMAGE, null, maxCount, 2, null), w());
        }
    }

    public final androidx.core.app.c w() {
        androidx.core.app.c cVarA = androidx.core.app.c.a(this.activity, 0, 0);
        kotlin.jvm.internal.p.h(cVarA, "makeCustomAnimation(...)");
        return cVarA;
    }

    public final void x(MainPagePreLoadAction model, InterfaceC5074l<? super Intent, Y8.t> decorateIntentBlock) {
        C4148a.u(TAG, "runInFakeMode not implemented: MainActivity reference not found, model: " + model.getActionName(), false, 4, null);
    }

    public final void y(boolean z10) {
        this.isFromFakeMode = z10;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ n(androidx.appcompat.app.d dVar, PickFileMediatorViewModel pickFileMediatorViewModel, f fVar, boolean z10, String str, int i10, kotlin.jvm.internal.i iVar) {
        f bVar = (i10 & 4) != 0 ? new b() : fVar;
        boolean z11 = (i10 & 8) != 0 ? false : z10;
        if ((i10 & 16) != 0) {
            str = "pick_file_result_" + keySeq.incrementAndGet();
        }
        this(dVar, pickFileMediatorViewModel, bVar, z11, str);
    }
}
