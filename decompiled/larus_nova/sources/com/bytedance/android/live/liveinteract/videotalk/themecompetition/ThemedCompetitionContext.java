package com.bytedance.android.live.liveinteract.videotalk.themecompetition;

import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.model.interact.SelectionType;
import com.bytedance.android.livesdk.chatroom.model.interact.ThemedCompetitionStatus;
import com.bytedance.android.livesdk.chatroom.model.interact.a2;
import com.bytedance.android.livesdk.chatroom.model.interact.b2;
import com.bytedance.android.livesdk.chatroom.model.interact.n1;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\u000eR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/themecompetition/ThemedCompetitionContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lpj0/a;", "Lcom/bytedance/live/datacontext/j;", "Lpj0/b;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Lcom/bytedance/live/datacontext/m;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/ThemedCompetitionStatus;", "status$delegate", "getStatus", "()Lcom/bytedance/live/datacontext/m;", "status", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/a2;", "info$delegate", "getInfo", "()Lcom/bytedance/live/datacontext/n;", "info", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ThemedCompetitionContext extends DataContext implements pj0.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p info$delegate;
    private final p service$delegate;
    private final p status$delegate;

    public static final class a {
        public a() {
        }

        public static boolean e() {
            IMiddlewareUserService r100 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
            if (r100 == null) goto L13;
            com.bytedance.android.livesdk.user.e r101 = r100.user();
            if (r101 == null) goto L13;
            UserAttr r102 = r101.q();
            if (r102 == null) goto L13;
            List<Integer> r103 = r102.getAdminPrivileges();
            if (r103 == null) goto L13;
            LiveRoomPermission.D.getClass();
            if (r103.contains(Integer.valueOf(LiveRoomPermission.f105071u.f105077a)) != true) goto L13;
            return true;
        L13:
            return false;
        }

        public final ThemedCompetitionContext getContext() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(pj0.a.class);
            if ((r100 instanceof ThemedCompetitionContext) == true) goto L6;
            r100 = null;
        L6:
            return (ThemedCompetitionContext) r100;
        }

        public final int b() {
            ThemedCompetitionContext r100 = getContext();
            if (r100 == null) goto L12;
            n<a2> r101 = r100.getInfo();
            if (r101 == null) goto L12;
            a2 r102 = r101.getValue();
            if (r102 == null) goto L12;
            b2 r103 = r102.getSetting();
            if (r103 == null) goto L12;
            return r103.getSelectionType();
        L12:
            return SelectionType.UNKNOWN.getValue();
        }

        public final pj0.b c() {
            ThemedCompetitionContext r100 = getContext();
            if (r100 == null) goto L7;
            j<pj0.b> r101 = r100.getService();
            if (r101 == null) goto L7;
            return r101.getValue();
        L7:
            return null;
        }

        public final boolean g() {
            ThemedCompetitionContext r100 = getContext();
            if (r100 == null) goto L7;
            m<ThemedCompetitionStatus> r101 = r100.getStatus();
            if (r101 == null) goto L7;
            ThemedCompetitionStatus r102 = r101.getValue();
        L9:
            if (r102 != ThemedCompetitionStatus.START) goto L11;
            return true;
        L11:
            return false;
        L7:
            r102 = null;
            goto L9
        }

        public final boolean h() {
            ThemedCompetitionContext r100 = getContext();
            ThemedCompetitionStatus r101 = null;
            if (r100 == null) goto L7;
            m<ThemedCompetitionStatus> r102 = r100.getStatus();
            if (r102 == null) goto L7;
            ThemedCompetitionStatus r103 = r102.getValue();
        L9:
            if (r103 == ThemedCompetitionStatus.START) goto L19;
            ThemedCompetitionContext r104 = getContext();
            if (r104 == null) goto L16;
            m<ThemedCompetitionStatus> r105 = r104.getStatus();
            if (r105 == null) goto L16;
            r101 = r105.getValue();
        L16:
            if (r101 == ThemedCompetitionStatus.SHOW_RESULT) goto L19;
            return false;
        L19:
            return true;
        L7:
            r103 = null;
            goto L9
        }

        public final String a(String r100) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_SCORE);
            int r101 = b();
            if (r101 != SelectionType.NORMAL.getValue()) goto L6;
            return r100;
        L6:
            if (r101 != SelectionType.SCORING.getValue()) goto L9;
            StringBuffer r102 = new StringBuffer();
            r102.append(r100);
            r102.append("分");
            return r102.toString();
        L9:
            return r100;
        }

        public final n1 d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            ThemedCompetitionContext r101 = getContext();
            if (r101 == null) goto L13;
            n<a2> r102 = r101.getInfo();
            if (r102 == null) goto L13;
            a2 r103 = r102.getValue();
            if (r103 == null) goto L13;
            Map<String, n1> r104 = r103.getUserIdStrToScore();
            if (r104 == null) goto L13;
            n1 r105 = r104.get(r100);
            if (r105 == null) goto L13;
            return r105;
        L13:
            return (n1) vh7.f.c(n1.class);
        }

        public final void f(a2 r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            int r101 = r100.getStatus();
            ThemedCompetitionStatus r102 = ThemedCompetitionStatus.START;
            if (r101 != r102.getValue()) goto L9;
            ThemedCompetitionContext r103 = getContext();
            if (r103 == null) goto L16;
            m<ThemedCompetitionStatus> r104 = r103.getStatus();
            if (r104 == null) goto L16;
            r104.setValue(r102);
        L16:
            ThemedCompetitionContext r105 = getContext();
            if (r105 == null) goto L22;
            n<a2> r106 = r105.getInfo();
            if (r106 == null) goto L23;
            r106.setValue(r100);
            return;
        L23:
            return;
        L22:
            return;
        L9:
            int r107 = r100.getStatus();
            ThemedCompetitionStatus r108 = ThemedCompetitionStatus.SHOW_RESULT;
            if (r107 != r108.getValue()) goto L16;
            ThemedCompetitionContext r109 = getContext();
            if (r109 == null) goto L16;
            m<ThemedCompetitionStatus> r110 = r109.getStatus();
            if (r110 == null) goto L16;
            r110.setValue(r108);
            goto L16
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ThemedCompetitionContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ThemedCompetitionContext.class, "status", "getStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ThemedCompetitionContext.class, "info", "getInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
    }

    public final n<a2> getInfo() {
        return (n) this.info$delegate.a(this, $$delegatedProperties[2]);
    }

    public final j<pj0.b> getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<ThemedCompetitionStatus> getStatus() {
        return (m) this.status$delegate.a(this, $$delegatedProperties[1]);
    }

    public ThemedCompetitionContext() {
        this.service$delegate = ConstantKt.c(this);
        this.status$delegate = q.d(this, ThemedCompetitionStatus.UNKNOWN);
        this.info$delegate = q.c(this);
    }
}
