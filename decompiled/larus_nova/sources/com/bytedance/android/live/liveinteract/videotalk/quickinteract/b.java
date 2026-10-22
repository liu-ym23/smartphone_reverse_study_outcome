package com.bytedance.android.live.liveinteract.videotalk.quickinteract;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.message.model.n7;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
public interface b {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final C1237b f79516r0 = null;

    public interface a {
        void a(n7 r100);

        int b(QuickInteractTask r100);

        void c(QuickInteractTask r100);
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.videotalk.quickinteract.b$b, reason: collision with other inner class name */
    public static final class C1237b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C1237b f79517a = null;

        public C1237b() {
        }

        static {
            f79517a = new C1237b();
        }

        @JvmStatic
        public static b a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d("quick_interact_service");
            if ((r100 instanceof QuickInteractContext) == true) goto L5;
            r100 = null;
        L5:
            QuickInteractContext r101 = (QuickInteractContext) r100;
            if (r101 == null) goto L11;
            j<b> r102 = r101.getService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }

        @JvmStatic
        public static boolean b() {
            o r100 = m.l(null, 0L);
            if (r100 == null) goto L5;
            Boolean r101 = r100.isAnchor();
        L7:
            if (Intrinsics.areEqual(r101, Boolean.TRUE) == true) goto L9;
            ReadOnlyProperty r102 = vm2.d.f555851h4;
            KProperty<?>[] r103 = vm2.d.f555776a;
            if (((Boolean) r102.getValue(null, r103[265(0x109, float:3.71E-43)])).booleanValue() == true) goto L13;
        L15:
            return false;
        L13:
            if (((Boolean) vm2.d.f555943q6.getValue(null, r103[378(0x17a, float:5.3E-43)])).booleanValue() == false) goto L15;
            return true;
        L9:
            return ((Boolean) vm2.d.f555851h4.getValue(null, vm2.d.f555776a[265(0x109, float:3.71E-43)])).booleanValue();
        L5:
            r101 = null;
            goto L7
        }

        @JvmStatic
        public static boolean c(ILinkPlayerInfoBridge r100) {
            if (r100 == null) goto L6;
            IBaseUser r101 = r100.getUser();
            if (r101 == null) goto L6;
            String r102 = r101.getIdString();
        L8:
            if (Intrinsics.areEqual(r102, je0.d.b0()) == true) goto L10;
        L12:
            return false;
        L10:
            if (b() == false) goto L12;
            return true;
        L6:
            r102 = null;
            goto L8
        }
    }

    public static final class c {
        public static /* synthetic */ void a(b r100, QuickInteractTask r101, String r102) {
            r100.vk(r101, r102, IQuickInteractService$sendThanksInteract$1.INSTANCE);
        }
    }

    static {
        f79516r0 = C1237b.f79517a;
    }

    void C9(BaseMultiLinkWindowManager.c r100);

    void F6();

    void Fn(String r100);

    void Si(QuickInteractTask r100, boolean r101);

    void Xb(QuickInteractTask r100);

    void aj(String r100, long r101, String r102, Function1<? super Integer, Unit> r103);

    boolean isEmpty();

    void k7(QuickInteractTask r100);

    void vk(QuickInteractTask r100, String r101, Function1<? super Integer, Unit> r102);
}
