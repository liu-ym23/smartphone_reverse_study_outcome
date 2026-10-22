package com.stepos.ailauncher.chat;

import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/chat/PickFileMediatorInDialog;", "Lcom/stepos/ailauncher/chat/c;", "Landroid/content/Context;", "context", "", "isFakeMode", "fromMoreMenu", "<init>", "(Landroid/content/Context;ZZ)V", "", "maxCount", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(I)V", "e", "()V", "release", "LUa/M;", Const.INTENT_KEY_UMID, "()LUa/M;", "", "type", "maxImageCount", "f", "(Ljava/lang/String;I)V", "Landroid/content/Context;", "Z", "mainScope", "LUa/M;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PickFileMediatorInDialog implements c {
    private static final String TAG = "PickFileMediatorInDialog";
    private final Context context;
    private final boolean fromMoreMenu;
    private final boolean isFakeMode;
    private M mainScope;

    public PickFileMediatorInDialog(Context context, boolean z10, boolean z11) {
        kotlin.jvm.internal.p.i(context, "context");
        this.context = context;
        this.isFakeMode = z10;
        this.fromMoreMenu = z11;
        this.mainScope = d();
    }

    public static /* synthetic */ void g(PickFileMediatorInDialog pickFileMediatorInDialog, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 10;
        }
        pickFileMediatorInDialog.f(str, i10);
    }

    public final M d() {
        return kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.c().getImmediate()));
    }

    public void e() {
        g(this, PickFileType.TYPE_DOC.getValue(), 0, 2, null);
    }

    public final void f(String type, int maxImageCount) {
        C4148a.d(TAG, "start to launch pickFile", false, 4, null);
        if (!kotlinx.coroutines.d.h(this.mainScope)) {
            C4148a.d(TAG, "mainScope was cancelled, rebuild before launch", false, 4, null);
            this.mainScope = d();
        }
        C1060i.d(this.mainScope, null, null, new PickFileMediatorInDialog$pickFile$1(this, type, maxImageCount, null), 3, null);
    }

    public void h(int maxCount) {
        f(PickFileType.TYPE_IMAGE.getValue(), maxCount);
    }

    @Override // com.stepos.ailauncher.chat.c
    public void release() {
        C4148a.d(TAG, "mainScope, release", false, 4, null);
        kotlinx.coroutines.d.e(this.mainScope, null, 1, null);
    }

    public /* synthetic */ PickFileMediatorInDialog(Context context, boolean z10, boolean z11, int i10, kotlin.jvm.internal.i iVar) {
        this(context, z10, (i10 & 4) != 0 ? false : z11);
    }
}
