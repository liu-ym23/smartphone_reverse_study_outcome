package com.stepos.ailauncher.task.space.credential;

import Ua.C1060i;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.C1398p;
import android.view.LifecycleOwner;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.view.C2851i7;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.R$string;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;
import y7.G;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 72\u00020\u0001:\u000289B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\tR\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010\u0018R\u0014\u00103\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00106\u001a\u00020#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u0006:"}, d2 = {"Lcom/stepos/ailauncher/task/space/credential/ThirdPartyAuthListFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "LY8/t;", "P", "Lcom/stepos/ailauncher/task/space/credential/f;", "item", "M", "(Lcom/stepos/ailauncher/task/space/credential/f;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "hidden", "onHiddenChanged", "(Z)V", "onDestroyView", "L", "Lcom/stepos/ailauncher/task/space/credential/g;", UxipConstants.f30685x, "Z", "(Lcom/stepos/ailauncher/task/space/credential/g;)V", "", "clickTarget", "N", "(Lcom/stepos/ailauncher/task/space/credential/f;Ljava/lang/String;)V", "", "authorizedCount", "O", "(I)V", ExifInterface.LONGITUDE_WEST, "Lr6/k;", "_binding", "Lr6/k;", "Lcom/stepos/ailauncher/task/space/credential/b;", "adapter", "Lcom/stepos/ailauncher/task/space/credential/b;", "Ly7/E;", "backGlassHandle", "Ly7/E;", "topBlurHandle", "Landroid/app/Dialog;", "currentDialog", "Landroid/app/Dialog;", "viewReported", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "showsSheetDragHandle", "K", "()Lr6/k;", "binding", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ThirdPartyAuthListFragment extends com.stepos.ailauncher.sheet.nav.a {
    private static final String ARG_ENTRY_SOURCE = "entry_source";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String NAV_TAG = "third_party_auth_list";
    private r6.k _binding;
    private C3590b adapter;
    private y7.E backGlassHandle;
    private Dialog currentDialog;
    private y7.E topBlurHandle;
    private boolean viewReported;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/task/space/credential/ThirdPartyAuthListFragment$a;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/graphics/Canvas;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", "onDrawOver", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "", "density", "F", "", "height", "I", "insetStart", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends RecyclerView.ItemDecoration {
        private final float density;
        private final int height;
        private final int insetStart;
        private final Paint paint;

        public a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            Paint paint = new Paint();
            paint.setColor(234881023);
            paint.setStyle(Paint.Style.FILL);
            this.paint = paint;
            float f10 = context.getResources().getDisplayMetrics().density;
            this.density = f10;
            this.height = (int) C5685n.e(f10 * 1.0f, 1.0f);
            this.insetStart = (int) (60 * f10);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(Canvas c10, RecyclerView parent, RecyclerView.State state) {
            kotlin.jvm.internal.p.i(c10, "c");
            kotlin.jvm.internal.p.i(parent, "parent");
            kotlin.jvm.internal.p.i(state, "state");
            int childCount = parent.getChildCount() - 1;
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = parent.getChildAt(i10);
                float paddingLeft = parent.getPaddingLeft() + this.insetStart;
                float width = parent.getWidth() - parent.getPaddingRight();
                float bottom = childAt.getBottom();
                c10.drawRect(paddingLeft, bottom, width, bottom + this.height, this.paint);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/task/space/credential/ThirdPartyAuthListFragment$b;", "", "<init>", "()V", "", "entrySource", "Lcom/stepos/ailauncher/task/space/credential/ThirdPartyAuthListFragment;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/ailauncher/task/space/credential/ThirdPartyAuthListFragment;", "NAV_TAG", "Ljava/lang/String;", "ARG_ENTRY_SOURCE", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.credential.ThirdPartyAuthListFragment$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final ThirdPartyAuthListFragment a(String entrySource) {
            kotlin.jvm.internal.p.i(entrySource, "entrySource");
            ThirdPartyAuthListFragment thirdPartyAuthListFragment = new ThirdPartyAuthListFragment();
            thirdPartyAuthListFragment.setArguments(x0.c.a(Y8.j.a(ThirdPartyAuthListFragment.ARG_ENTRY_SOURCE, entrySource)));
            return thirdPartyAuthListFragment;
        }

        public Companion() {
        }
    }

    public ThirdPartyAuthListFragment() {
        super(R$layout.fragment_third_party_auth_list);
    }

    private final void M(CredentialItem item) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new ThirdPartyAuthListFragment$performRevoke$1(item, this, null), 3, null);
    }

    private final void P() {
        K().btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.credential.H
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ThirdPartyAuthListFragment.Q(this.f28950a, view);
            }
        });
        K().btnBack.post(new Runnable() { // from class: com.stepos.ailauncher.task.space.credential.I
            @Override // java.lang.Runnable
            public final void run() {
                ThirdPartyAuthListFragment.R(this.f28951a);
            }
        });
        K().topChromeBlur.post(new Runnable() { // from class: com.stepos.ailauncher.task.space.credential.J
            @Override // java.lang.Runnable
            public final void run() {
                ThirdPartyAuthListFragment.S(this.f28952a);
            }
        });
        this.adapter = new C3590b(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.credential.K
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThirdPartyAuthListFragment.U(this.f28953a, (CredentialItem) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.credential.L
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThirdPartyAuthListFragment.V(this.f28954a, (CredentialItem) obj);
            }
        });
        K().rvAuthList.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView recyclerView = K().rvAuthList;
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        recyclerView.addItemDecoration(new a(contextRequireContext));
        RecyclerView recyclerView2 = K().rvAuthList;
        C3590b c3590b = this.adapter;
        if (c3590b == null) {
            kotlin.jvm.internal.p.A("adapter");
            c3590b = null;
        }
        recyclerView2.setAdapter(c3590b);
    }

    public static final void Q(ThirdPartyAuthListFragment thirdPartyAuthListFragment, View view) {
        thirdPartyAuthListFragment.x();
    }

    public static final void R(ThirdPartyAuthListFragment thirdPartyAuthListFragment) {
        C2851i7 c2851i7 = C2851i7.INSTANCE;
        ImageView btnBack = thirdPartyAuthListFragment.K().btnBack;
        kotlin.jvm.internal.p.h(btnBack, "btnBack");
        thirdPartyAuthListFragment.backGlassHandle = C2851i7.d(c2851i7, btnBack, false, Float.valueOf(22.0f), null, 8, null);
    }

    public static final void S(ThirdPartyAuthListFragment thirdPartyAuthListFragment) {
        C2851i7 c2851i7 = C2851i7.INSTANCE;
        View topChromeBlur = thirdPartyAuthListFragment.K().topChromeBlur;
        kotlin.jvm.internal.p.h(topChromeBlur, "topChromeBlur");
        thirdPartyAuthListFragment.topBlurHandle = C2851i7.f(c2851i7, topChromeBlur, false, G.a.f43886a.g(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.credential.M
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThirdPartyAuthListFragment.T((A7.B) obj);
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t T(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public static final Y8.t U(ThirdPartyAuthListFragment thirdPartyAuthListFragment, CredentialItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        thirdPartyAuthListFragment.N(item, "card");
        com.stepos.ailauncher.sheet.nav.a.z(thirdPartyAuthListFragment, ThirdPartyAuthDetailFragment.INSTANCE.a(item.getVendorId()), ThirdPartyAuthDetailFragment.NAV_TAG, null, null, null, 28, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t V(ThirdPartyAuthListFragment thirdPartyAuthListFragment, CredentialItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        thirdPartyAuthListFragment.N(item, "cancel");
        thirdPartyAuthListFragment.W(item);
        return Y8.t.f7040a;
    }

    public static final Y8.t X(ThirdPartyAuthListFragment thirdPartyAuthListFragment, CredentialItem credentialItem) {
        thirdPartyAuthListFragment.M(credentialItem);
        return Y8.t.f7040a;
    }

    public static final void Y(ThirdPartyAuthListFragment thirdPartyAuthListFragment, DialogInterface dialogInterface) {
        thirdPartyAuthListFragment.currentDialog = null;
    }

    public final r6.k K() {
        r6.k kVar = this._binding;
        kotlin.jvm.internal.p.f(kVar);
        return kVar;
    }

    public final void L() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new ThirdPartyAuthListFragment$loadData$1(this, null), 3, null);
    }

    public final void N(CredentialItem item, String clickTarget) {
        P.INSTANCE.c(clickTarget, item.getVendorId(), Q.d(item));
    }

    public final void O(int authorizedCount) {
        if (this.viewReported) {
            return;
        }
        this.viewReported = true;
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ARG_ENTRY_SOURCE) : null;
        if (string == null) {
            string = "";
        }
        P.INSTANCE.g(authorizedCount, string);
    }

    public final void W(final CredentialItem item) {
        Dialog dialogN = r.n(this, item.getVendorName(), new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.credential.N
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ThirdPartyAuthListFragment.X(this.f28955a, item);
            }
        }, null, 4, null);
        if (dialogN != null) {
            dialogN.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.stepos.ailauncher.task.space.credential.O
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    ThirdPartyAuthListFragment.Y(this.f28957a, dialogInterface);
                }
            });
        } else {
            dialogN = null;
        }
        this.currentDialog = dialogN;
    }

    public final void Z(CredentialListData response) {
        r6.k kVar = this._binding;
        if (kVar == null) {
            return;
        }
        int total = response.getTotal();
        O(total);
        kVar.tvAuthorizedCount.setText(getString(R$string.third_party_auth_authorized_count, Integer.valueOf(total)));
        if (response.a().isEmpty()) {
            kVar.scrollAuthList.setVisibility(8);
            kVar.layoutEmpty.setVisibility(0);
            return;
        }
        kVar.scrollAuthList.setVisibility(0);
        kVar.layoutEmpty.setVisibility(8);
        C3590b c3590b = this.adapter;
        if (c3590b == null) {
            kotlin.jvm.internal.p.A("adapter");
            c3590b = null;
        }
        c3590b.submitList(response.a());
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.currentDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.currentDialog = null;
        C2851i7 c2851i7 = C2851i7.INSTANCE;
        c2851i7.h(this.backGlassHandle);
        this.backGlassHandle = null;
        c2851i7.h(this.topBlurHandle);
        this.topBlurHandle = null;
        this._binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            return;
        }
        L();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this._binding = r6.k.a(view);
        P();
        L();
    }
}
