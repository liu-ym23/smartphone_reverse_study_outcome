package com.bytedance.android.livesdk.interactivity.publicscreen.panel.item;

import am2.x;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.m4;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AudiencePanelItemSymbol;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.v;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public abstract class b implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f138969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CompositeDisposable f138970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f138971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public v f138972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AudiencePanelItemSymbol f138973e;

    public static final class a {
    }

    static {
    }

    public abstract int c();

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public void onDestroyView() {
        this.f138969a = null;
        CompositeDisposable r100 = this.f138970b;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f138970b = null;
    }

    public final boolean d() {
        t r100 = this.f138971c;
        if ((r100 instanceof m4) == true) goto L5;
        r100 = null;
    L5:
        m4 r101 = (m4) r100;
        if (r101 == null) goto L8;
        IBaseUser r102 = r101.getUser();
    L9:
        if (r102 == null) goto L11;
        String r103 = r102.getUserId();
    L12:
        MiddlewareRoomContext r104 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 2);
        if (r104 == null) goto L17;
        m<User> r105 = r104.getUser();
        if (r105 == null) goto L17;
        User r106 = r105.getValue();
    L18:
        if (r106 == null) goto L20;
        String r107 = r106.getUserId();
    L22:
        return StringsKt.equals$default(r107, r103, false, 2, null);
    L20:
        r107 = null;
    L17:
        r106 = null;
        goto L18
    L11:
        r103 = null;
        goto L12
    L8:
        r102 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final AudiencePanelItemSymbol a() {
        return this.f138973e;
    }

    public b(AudiencePanelItemSymbol r100) {
        Intrinsics.checkNotNullParameter(r100, "symbol");
        this.f138973e = r100;
        this.f138970b = new CompositeDisposable();
    }

    public void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        View r101 = this.f138969a;
        if (r101 == null) goto L8;
        TextView r102 = (TextView) r101.findViewById(R.id.item_desc);
        if (r102 == null) goto L9;
        r102.setText(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final View getView(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.f138969a != null) goto L11;
        View r101 = LayoutInflater.from(r100).inflate(c(), null);
        this.f138969a = r101;
        if (r101 == null) goto L11;
        r101.setTag(this.f138973e);
    L11:
        return this.f138969a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public void onClick(View r100) {
        if (this.f138973e.getShowOutside() == false) goto L5;
        String r101 = PullConfiguration.PROCESS_NAME_MAIN;
    L6:
        e("default", r101, "default");
        return;
    L5:
        r101 = "secondary";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public void b(t r100, v r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "bridge");
        this.f138972d = r101;
        f((String) ListProtector.get(this.f138973e.getOutsideName(), 0));
    }

    public final void e(String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "functionStatus");
        Intrinsics.checkNotNullParameter(r111, "functionLevel");
        Intrinsics.checkNotNullParameter(r112, "functionValue");
        int r100 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.g.f133637a;
        Map r101 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.g.a(this.f138971c);
        t r102 = this.f138971c;
        String r103 = "";
        if (r102 == null) goto L6;
        String r104 = String.valueOf(r102.getMessageId());
        if (r104 == null) goto L6;
    L7:
        String r105 = String.valueOf(this.f138973e.getId());
        String r106 = String.valueOf(System.currentTimeMillis());
        Intrinsics.checkNotNullParameter(r104, "commentId");
        Intrinsics.checkNotNullParameter(r111, "function_level");
        Intrinsics.checkNotNullParameter(r105, "function_name");
        Intrinsics.checkNotNullParameter(r110, "function_status");
        Intrinsics.checkNotNullParameter(r112, "function_value");
        Intrinsics.checkNotNullParameter(r106, "event_time");
        Intrinsics.checkNotNullParameter(r101, "extra");
        HashMap r113 = new HashMap();
        r113.putAll(r101);
        r113.put("comment_id", r104);
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.g.b() == false) goto L10;
        String r107 = "1";
    L11:
        r113.put("is_comment_connected", r107);
        r113.put("function_level", r111);
        r113.put("function_name", r105);
        r113.put("function_status", r110);
        r113.put("function_value", r112);
        r113.put("event_time", r106);
        IMiddlewareLiveService r114 = (IMiddlewareLiveService) jc1.k.f(IMiddlewareLiveService.class);
        if (r114 == null) goto L19;
        ILiveOntologyInfoManager r115 = r114.getLiveOntologyRecord();
        if (r115 == null) goto L19;
        String r116 = r115.getEnterFromMerge();
        if (r116 == null) goto L19;
        r103 = r116;
    L19:
        r113.put(ILiveRoomPlayFragmentConstant.EXTRA_VS_DRAWER_PAGE, r103);
        j0.l().sendLog("livesdk_live_message_function_click", r113, new Object[]{new x(), IRoom.class});
        return;
    L10:
        r107 = "0";
    L6:
        r104 = "";
        goto L7
    }
}
