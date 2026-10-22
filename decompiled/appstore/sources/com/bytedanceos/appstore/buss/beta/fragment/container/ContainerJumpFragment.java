package com.bytedanceos.appstore.buss.beta.fragment.container;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedanceos.appstore.buss.fragment.AppDetailFragment;
import com.bytedanceos.appstore.buss.fragment.AppUpdateFragment;
import com.bytedanceos.appstore.buss.fragment.TopicFragment;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.obric.appstore.R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.text.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0014X\u0094D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00148TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedanceos/appstore/buss/beta/fragment/container/ContainerJumpFragment;", "Lh7/c;", "<init>", "()V", "", "E", "initData", "F", "t", "G", "", "f", "Z", "q", "()Z", "showHeader", "", "n", "()I", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "g", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nContainerJumpFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContainerJumpFragment.kt\ncom/bytedanceos/appstore/buss/beta/fragment/container/ContainerJumpFragment\n+ 2 FragmentManager.kt\nandroidx/fragment/app/FragmentManagerKt\n*L\n1#1,130:1\n28#2,12:131\n28#2,12:143\n28#2,12:155\n*S KotlinDebug\n*F\n+ 1 ContainerJumpFragment.kt\ncom/bytedanceos/appstore/buss/beta/fragment/container/ContainerJumpFragment\n*L\n97#1:131,12\n112#1:143,12\n122#1:155,12\n*E\n"})
public final class ContainerJumpFragment extends h7.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f8409g = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f8410f;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a(String r10, int r11, String r12) {
            q.g(r10, "packageName");
            ContainerJumpFragment r13 = new ContainerJumpFragment();
            r13.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a("deepLink", "deepLink_app_detail"), kotlin.d.a("packageName", r10), kotlin.d.a("autoDownload", Integer.valueOf(r11)), kotlin.d.a(NetKey.PAGE_SOURCE, r12)}));
            return r13;
        }

        public final Fragment b(boolean r10, boolean r11) {
            ContainerJumpFragment r12 = new ContainerJumpFragment();
            r12.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a("deepLink", "deepLink_app_update"), kotlin.d.a("fromNotification", Boolean.valueOf(r10)), kotlin.d.a("updateAll", Boolean.valueOf(r11))}));
            return r12;
        }

        public final Fragment c(String r10) {
            q.g(r10, "topicId");
            ContainerJumpFragment r11 = new ContainerJumpFragment();
            r11.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a("deepLink", "deepLink_topic"), kotlin.d.a("topicId", r10)}));
            return r11;
        }

        public a() {
        }
    }

    static {
        f8409g = new a(null);
    }

    public ContainerJumpFragment() {
    }

    @Override // h7.c
    public void E() {
        r();
    }

    @Override // h7.c
    public void F() {
    }

    public final void G() {
        Bundle r10 = getArguments();
        String r11 = null;
        Boolean r12 = null;
        if (r10 == null) goto L5;
        String r13 = r10.getString("deepLink");
    L6:
        if (r13 == null) goto L63;
        int r14 = r13.hashCode();
        if (r14 == (-560287992)) goto L41;
        if (r14 == (-63910016)) goto L30;
        if (r14 == 1057431222) goto L15;
        return;
    L15:
        if (r13.equals("deepLink_topic") == false) goto L72;
        Bundle r15 = getArguments();
        if (r15 == null) goto L20;
        String r16 = r15.getString("topicId");
    L21:
        if (r16 != null) goto L23;
    L26:
        FragmentActivity r17 = getActivity();
        if (r17 == null) goto L65;
        r17.finish();
        return;
    L65:
        return;
    L23:
        if (o.r(r16) == true) goto L26;
        FragmentManager r18 = getChildFragmentManager();
        q.f(r18, "getChildFragmentManager(...)");
        FragmentTransaction r19 = r18.o();
        q.f(r19, "beginTransaction()");
        r19.u(R.id.fl_container, TopicFragment.f8659n.a(null, r16, false));
        r19.j();
        return;
    L20:
        r16 = null;
        goto L21
    L72:
        return;
    L30:
        if (r13.equals("deepLink_app_update") == false) goto L73;
        Bundle r20 = getArguments();
        if (r20 == null) goto L35;
        Boolean r21 = Boolean.valueOf(r20.getBoolean("fromNotification", false));
    L36:
        q.d(r21);
        boolean r22 = r21.booleanValue();
        Bundle r23 = getArguments();
        if (r23 == null) goto L39;
        r12 = Boolean.valueOf(r23.getBoolean("updateAll", false));
    L39:
        q.d(r12);
        boolean r24 = r12.booleanValue();
        FragmentManager r110 = getChildFragmentManager();
        q.f(r110, "getChildFragmentManager(...)");
        FragmentTransaction r111 = r110.o();
        q.f(r111, "beginTransaction()");
        r111.u(R.id.fl_container, AppUpdateFragment.f8529q.a(r22, r24, "page_update_apps"));
        r111.j();
        return;
    L35:
        r21 = null;
        goto L36
    L73:
        return;
    L41:
        if (r13.equals("deepLink_app_detail") == false) goto L68;
        Bundle r25 = getArguments();
        if (r25 == null) goto L45;
        String r26 = r25.getString("packageName");
    L46:
        Bundle r27 = getArguments();
        if (r27 == null) goto L49;
        Integer r28 = Integer.valueOf(r27.getInt("autoDownload"));
    L50:
        q.d(r28);
        int r112 = r28.intValue();
        Bundle r29 = getArguments();
        if (r29 == null) goto L53;
        r11 = r29.getString(NetKey.PAGE_SOURCE);
    L53:
        String r113 = r11;
        if (r26 != null) goto L56;
    L59:
        FragmentActivity r114 = getActivity();
        if (r114 == null) goto L70;
        r114.finish();
        return;
    L70:
        return;
    L56:
        if (o.r(r26) == true) goto L59;
        FragmentManager r115 = getChildFragmentManager();
        q.f(r115, "getChildFragmentManager(...)");
        FragmentTransaction r116 = r115.o();
        q.f(r116, "beginTransaction()");
        r116.u(R.id.fl_container, AppDetailFragment.a.b(AppDetailFragment.f8472z, r26, null, false, r112, r113, 2, null));
        r116.j();
        return;
    L49:
        r28 = null;
        goto L50
    L45:
        r26 = null;
        goto L46
    L68:
        return;
    L63:
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Override // h7.c
    public void initData() {
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_container;
    }

    @Override // h7.c
    public Function0 o() {
        return ContainerJumpFragment$onRetryListener$1.INSTANCE;
    }

    @Override // h7.c
    public boolean q() {
        return this.f8410f;
    }

    @Override // h7.c
    public void t() {
        G();
    }
}
