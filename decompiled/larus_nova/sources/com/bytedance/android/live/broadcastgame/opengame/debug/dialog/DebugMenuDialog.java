package com.bytedance.android.live.broadcastgame.opengame.debug.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.opengame.debug.c;
import com.bytedance.android.live.broadcastgame.opengame.debug.j;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.crash.d;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n10.b;
import n10.f;
import n10.g;
import n10.h;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/debug/dialog/DebugMenuDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DebugMenuDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<h> f59999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f60000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f60001c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DebugMenuDialog f60002a;

        public a(DebugMenuDialog r100) {
            this.f60002a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            DebugMenuDialog r101 = this.f60002a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_open_game_debug_menu_dialog;
    }

    public final LinkedList<h> M0() {
        int r100 = n10.a.f516653a[this.f60001c.getPluginType().ordinal()];
        if (r100 != 1) goto L5;
    L13:
        LinkedList<h> r101 = new LinkedList();
        InteractGameContext r102 = InteractGameContext.Companion.getContext();
        if (r102 == null) goto L18;
        n<Boolean> r103 = r102.getHasOpenGameLaunch();
        if (r103 == null) goto L18;
        Boolean r104 = r103.getValue();
    L20:
        if ((!Intrinsics.areEqual(r104, Boolean.TRUE)) == false) goto L22;
        r101.add(new h("扫描", new n10.c(this)));
        return r101;
    L22:
        r101.add(new h("弹起小插件", new n10.d(this)));
        if (this.f60000b == false) goto L50;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r105 = AnchorGameContext.a.a();
        if (r105 == null) goto L31;
        m<Boolean> r106 = r105.getOpenGamePerfPanel();
        if (r106 == null) goto L31;
        Boolean r107 = r106.getValue();
        if (r107 == null) goto L31;
        boolean r108 = r107.booleanValue();
    L32:
        r101.add(new h(r108));
        AnchorGameContext r109 = AnchorGameContext.a.a();
        if (r109 == null) goto L51;
        m<Boolean> r110 = r109.isLaunchFromPerfTest();
        if (r110 != null) goto L37;
        return r101;
    L37:
        if (r110.getValue().booleanValue() != true) goto L53;
        AnchorGameContext r111 = AnchorGameContext.a.a();
        if (r111 == null) goto L54;
        m<Boolean> r112 = r111.getOpenGamePerfUploadState();
        if (r112 != null) goto L43;
        return r101;
    L43:
        if (r112.getValue().booleanValue() != true) goto L56;
        r101.add(new h("停止性能数据上报", new f(this)));
        return r101;
    L56:
        return r101;
    L54:
        return r101;
    L53:
        return r101;
    L51:
        return r101;
    L31:
        r108 = false;
        goto L32
    L50:
        return r101;
    L18:
        r104 = null;
        goto L20
    L5:
        if (r100 == 2) goto L13;
        if (r100 != 3) goto L9;
        LinkedList<h> r113 = new LinkedList();
        r113.add(new h("扫描", new g(this)));
        return r113;
    L9:
        if ((this.f60001c instanceof j) == false) goto L47;
        LinkedList<h> r114 = new LinkedList();
        r114.add(new h("扫描", new b(this)));
        return r114;
    L47:
        return new LinkedList();
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f59999a.clear();
        this.f59999a.addAll(M0());
        RecyclerView r100 = (RecyclerView) findViewById(R.id.recyclerView);
        if (r100 == null) goto L8;
        RecyclerView.Adapter r101 = r100.getAdapter();
        if (r101 == null) goto L9;
        r101.notifyDataSetChanged();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r101 == null) goto L9;
        i<Boolean> r102 = r101.isAnchor();
        if (r102 == null) goto L9;
        Boolean r103 = r102.getValue();
        if (r103 == null) goto L9;
        boolean r104 = r103.booleanValue();
    L10:
        this.f60000b = r104;
        RecyclerView r105 = (RecyclerView) findViewById(R.id.recyclerView);
        if (r105 == null) goto L13;
        r105.setAdapter(new DebugMenuAdapter(this.f59999a));
        r105.setLayoutManager(new LinearLayoutManager(r105.getContext(), 1, false));
        r105.addItemDecoration(new DividerItemDecoration(r105.getContext(), 1));
    L13:
        TextView r106 = (TextView) findViewById(R.id.cancel);
        if (r106 == null) goto L17;
        r106.setOnClickListener(new a(this));
        return;
    L17:
        return;
    L9:
        r104 = false;
        goto L10
    }

    public DebugMenuDialog(Context r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "executor");
        super(r100);
        this.f60001c = r101;
        this.f59999a = M0();
    }
}
