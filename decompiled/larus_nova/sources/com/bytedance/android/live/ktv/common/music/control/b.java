package com.bytedance.android.live.ktv.common.music.control;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class b extends d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IMusicControlNode.OperationType f70011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Context f70012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f70013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f70014i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f70015j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final IRoom f70016k;

    public static final class a {
    }

    static {
    }

    public void f(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "panel");
    }

    public void i(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "panel");
    }

    public void j(int r100, MusicPanel r101) {
        Intrinsics.checkNotNullParameter(r101, "panel");
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.d
    public final void c() {
        Disposable r100 = this.f70022b;
        if (r100 == null) goto L6;
        r100.dispose();
    L6:
        if (this.f70015j == false) goto L8;
        f(this.f70024d);
        return;
    L8:
        MusicPanel r101 = this.f70024d;
        Intrinsics.checkNotNullParameter(r101, "panel");
        i(r101);
    }

    public final Context getContext() {
        return this.f70012g;
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.d, com.bytedance.android.live.ktv.common.music.control.IMusicControlNode
    public IMusicControlNode.OperationType getType() {
        return this.f70011f;
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.d, com.bytedance.android.live.ktv.common.music.control.IMusicControlNode
    public final void b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        mb0.d.g("node_process", this.f70024d);
        super.b(r100);
    }

    public final void g(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        r100.f153578b = 1;
        j(2, r100);
        g r101 = this.f70023c;
        if (r101 == null) goto L9;
        IMusicControlNode.OperationType r102 = getType();
        if (this.f70013h != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("enterFrom");
    L7:
        r101.c(new IMusicControlNode.b(r102, r100), this);
        return;
    }

    public final void h(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        r100.f153578b = 4;
        r100.f153599w = System.currentTimeMillis();
        j(0, r100);
        g r101 = this.f70023c;
        if (r101 == null) goto L9;
        IMusicControlNode.OperationType r102 = getType();
        if (this.f70013h != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("enterFrom");
    L7:
        r101.b(new IMusicControlNode.b(r102, r100), this);
        return;
    }

    public b(MusicPanel r100, ModeType r101) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
        Intrinsics.checkNotNullParameter(r101, "modeType");
        super(r100, r101);
        this.f70011f = IMusicControlNode.OperationType.ADD_MUSIC;
        this.f70015j = true;
        m<IRoom> r102 = o3.f().getRoom();
        if (r102 == null) goto L5;
        IRoom r103 = r102.getValue();
    L6:
        this.f70016k = r103;
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static void e(b r100, Context r101, String r102, String r103, boolean r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r105 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 16) == 0) goto L11;
        r104 = true;
    L11:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "enterFrom");
        r100.f70012g = r101;
        r100.f70013h = r102;
        r100.f70014i = r103;
        r100.f70015j = r104;
    }
}
