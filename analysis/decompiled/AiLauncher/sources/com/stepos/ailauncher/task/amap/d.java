package com.stepos.ailauncher.task.amap;

import T5.s;
import Y8.t;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.LifecycleOwner;
import android.view.View;
import android.widget.FrameLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiLiveClickReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.amap.PoiDetailCardItem;
import com.stepos.ailauncher.foundation.appui.card.provider.amap.PoiDetailStyle;
import com.stepos.ailauncher.foundation.appui.card.provider.amap.U;
import com.stepos.ailauncher.sheet.R$dimen;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0012\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/task/amap/d;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "LT5/s;", "binding", "C", "(LT5/s;)V", "", AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, "webLink", "F", "(Ljava/lang/String;Ljava/lang/String;)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "showsSheetDragHandle", "Companion", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d extends com.stepos.ailauncher.sheet.nav.a {
    private static final String ARG_DETAIL_JSON = "detail_json";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float FOOTER_GAP_DP = 22.0f;
    private static final float NAV_HANDLE_TOP_DP = 14.0f;
    private static final String TAG = "PoiDetailSheetFrag";

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/task/amap/d$a;", "", "<init>", "()V", "", "detailJson", "Lcom/stepos/ailauncher/task/amap/d;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/ailauncher/task/amap/d;", "TAG", "Ljava/lang/String;", "ARG_DETAIL_JSON", "", "NAV_HANDLE_TOP_DP", "F", "FOOTER_GAP_DP", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.amap.d$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final d a(String detailJson) {
            p.i(detailJson, "detailJson");
            d dVar = new d();
            Bundle bundle = new Bundle();
            bundle.putString(d.ARG_DETAIL_JSON, detailJson);
            dVar.setArguments(bundle);
            return dVar;
        }

        public Companion() {
        }
    }

    public d() {
        super(R$layout.fragment_poi_detail_sheet);
    }

    public static final void D(d dVar, View view) {
        dVar.o();
    }

    public static final t E(d dVar, String str, String str2) {
        dVar.F(str, str2);
        return t.f7040a;
    }

    public final void C(s binding) throws Resources.NotFoundException {
        float f10 = getResources().getDisplayMetrics().density * 36.0f;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.ail_sheet_content_padding);
        FrameLayout flPoiFooter = binding.flPoiFooter;
        p.h(flPoiFooter, "flPoiFooter");
        flPoiFooter.setPadding(flPoiFooter.getPaddingLeft(), flPoiFooter.getPaddingTop(), flPoiFooter.getPaddingRight(), C5685n.f(((int) f10) - dimensionPixelSize, 0));
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto Ld
            boolean r1 = La.H.x0(r7)
            if (r1 != 0) goto La
            goto Lb
        La:
            r7 = r0
        Lb:
            if (r7 != 0) goto L1c
        Ld:
            if (r8 == 0) goto L18
            boolean r7 = La.H.x0(r8)
            if (r7 != 0) goto L16
            goto L17
        L16:
            r8 = r0
        L17:
            r0 = r8
        L18:
            if (r0 != 0) goto L1b
            goto L66
        L1b:
            r7 = r0
        L1c:
            kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L39
            android.content.Intent r8 = new android.content.Intent     // Catch: java.lang.Throwable -> L39
            java.lang.String r0 = "android.intent.action.VIEW"
            android.net.Uri r1 = android.net.Uri.parse(r7)     // Catch: java.lang.Throwable -> L39
            r8.<init>(r0, r1)     // Catch: java.lang.Throwable -> L39
            r0 = 268435456(0x10000000, float:2.524355E-29)
            android.content.Intent r8 = r8.addFlags(r0)     // Catch: java.lang.Throwable -> L39
            r6.startActivity(r8)     // Catch: java.lang.Throwable -> L39
            Y8.t r6 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L39
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch: java.lang.Throwable -> L39
            goto L45
        L39:
            r0 = move-exception
            r6 = r0
            kotlin.Result$a r8 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.C4849c.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
        L45:
            java.lang.Throwable r2 = kotlin.Result.e(r6)
            if (r2 == 0) goto L66
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "open link failed uri="
            r6.append(r8)
            r6.append(r7)
            java.lang.String r1 = r6.toString()
            r4 = 8
            r5 = 0
            java.lang.String r0 = "PoiDetailSheetFrag"
            r3 = 0
            h8.C4148a.t(r0, r1, r2, r3, r4, r5)
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.amap.d.F(java.lang.String, java.lang.String):void");
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws Resources.NotFoundException {
        Object objB;
        p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.poiDetailSheetRoot);
        View viewFindViewById = view.findViewById(R$id.btn_close);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, false, 2, null);
        p.f(viewFindViewById);
        C2773b6.p(c2773b6, new View[]{viewFindViewById}, null, false, 6, null);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.amap.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d.D(this.f28379a, view2);
            }
        });
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ARG_DETAIL_JSON) : null;
        if (string == null) {
            string = "";
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((PoiDetailCardItem) new Gson().fromJson(string, PoiDetailCardItem.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        PoiDetailCardItem n10 = (PoiDetailCardItem) objB;
        if (n10 == null) {
            C4148a.u(TAG, "invalid detail json, dismiss", false, 4, null);
            o();
            return;
        }
        s sVarC = s.c(LayoutInflater.from(requireContext()), frameLayout, true);
        p.h(sVarC, "inflate(...)");
        sVarC.b().setBackground(null);
        sVarC.b().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        sVarC.scrollPoiDetail.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        C(sVarC);
        U.INSTANCE.h(sVarC, n10, new p9.p() { // from class: com.stepos.ailauncher.task.amap.c
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return d.E(this.f28380a, (String) obj, (String) obj2);
            }
        }, null, PoiDetailStyle.INSTANCE.b());
        sVarC.ivGalleryClose.setVisibility(8);
    }
}
