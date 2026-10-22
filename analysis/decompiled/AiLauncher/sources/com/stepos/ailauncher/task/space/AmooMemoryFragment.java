package com.stepos.ailauncher.task.space;

import Ua.C1060i;
import android.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.C1398p;
import android.view.LayoutInflater;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.R$string;
import h8.C4148a;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J!\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/stepos/ailauncher/task/space/AmooMemoryFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "LY8/t;", "Q", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "O", "P", "", x5.d.EXTRA_ENABLED, "b0", "(Z)V", ExifInterface.LONGITUDE_WEST, "Lr6/e;", "_binding", "Lr6/e;", "", "currentVersion", "I", "isUpdating", "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "showsSheetDragHandle", "N", "()Lr6/e;", "binding", "Companion", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmooMemoryFragment extends com.stepos.ailauncher.sheet.nav.a {
    private static final String TAG = "AILauncher-AmooMemory";
    private r6.e _binding;
    private int currentVersion;
    private boolean isUpdating;

    public AmooMemoryFragment() {
        super(R$layout.fragment_amoo_memory);
    }

    private final void Q() {
        N().btnClose.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AmooMemoryFragment.R(this.f29086a, view);
            }
        });
        N().switchMemoryShare.setChecked(true);
        N().itemMemoryShare.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AmooMemoryFragment.S(this.f29104a, view);
            }
        });
        N().itemAboutMe.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AmooMemoryFragment.T(this.f29109a, view);
            }
        });
        N().itemCommunication.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AmooMemoryFragment.U(this.f29112a, view);
            }
        });
        N().itemMemo.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AmooMemoryFragment.V(this.f29117a, view);
            }
        });
    }

    public static final void R(AmooMemoryFragment amooMemoryFragment, View view) {
        amooMemoryFragment.o();
    }

    public static final void S(AmooMemoryFragment amooMemoryFragment, View view) {
        if (amooMemoryFragment.isUpdating) {
            return;
        }
        if (amooMemoryFragment.N().switchMemoryShare.getIsChecked()) {
            amooMemoryFragment.W();
        } else {
            amooMemoryFragment.b0(true);
        }
    }

    public static final void T(AmooMemoryFragment amooMemoryFragment, View view) {
        com.stepos.ailauncher.sheet.nav.a.z(amooMemoryFragment, AmooMemoryDetailFragment.INSTANCE.b(0), AmooMemoryDetailFragment.NAV_TAG, null, null, null, 28, null);
    }

    public static final void U(AmooMemoryFragment amooMemoryFragment, View view) {
        com.stepos.ailauncher.sheet.nav.a.z(amooMemoryFragment, AmooMemoryDetailFragment.INSTANCE.b(1), AmooMemoryDetailFragment.NAV_TAG, null, null, null, 28, null);
    }

    public static final void V(AmooMemoryFragment amooMemoryFragment, View view) {
        com.stepos.ailauncher.sheet.nav.a.z(amooMemoryFragment, AmooMemoryDetailFragment.INSTANCE.b(2), AmooMemoryDetailFragment.NAV_TAG, null, null, null, 28, null);
    }

    public static final void X(Dialog dialog, View view) {
        dialog.dismiss();
    }

    public static final void Y(Dialog dialog, AmooMemoryFragment amooMemoryFragment, View view) {
        dialog.dismiss();
        amooMemoryFragment.b0(false);
    }

    public static final void Z(Dialog dialog, View view) {
        dialog.dismiss();
    }

    public static final void a0(View view) {
    }

    public static final Y8.t c0(final AmooMemoryFragment amooMemoryFragment, final boolean z10, final MemorySettingState memorySettingState) {
        View view = amooMemoryFragment.getView();
        if (view != null) {
            view.post(new Runnable() { // from class: com.stepos.ailauncher.task.space.q
                @Override // java.lang.Runnable
                public final void run() {
                    AmooMemoryFragment.d0(this.f29093a, memorySettingState, z10);
                }
            });
        }
        return Y8.t.f7040a;
    }

    public static final void d0(AmooMemoryFragment amooMemoryFragment, MemorySettingState memorySettingState, boolean z10) {
        r6.e eVar = amooMemoryFragment._binding;
        if (eVar == null) {
            return;
        }
        amooMemoryFragment.isUpdating = false;
        if (memorySettingState == null) {
            eVar.switchMemoryShare.setChecked(!z10);
            C4148a.u(TAG, "Failed to update memory setting, reverting", false, 4, null);
            return;
        }
        amooMemoryFragment.currentVersion = memorySettingState.getVersion();
        eVar.switchMemoryShare.setChecked(memorySettingState.getMemoryShareEnabled());
        C4148a.d(TAG, "Updated setting: enabled=" + memorySettingState.getMemoryShareEnabled() + ", version=" + memorySettingState.getVersion(), false, 4, null);
    }

    public final r6.e N() {
        r6.e eVar = this._binding;
        kotlin.jvm.internal.p.f(eVar);
        return eVar;
    }

    public final void O() {
        MemorySettingState memorySettingStateJ = MemorySettingApi.INSTANCE.J();
        if (memorySettingStateJ != null) {
            this.currentVersion = memorySettingStateJ.getVersion();
            N().switchMemoryShare.setChecked(memorySettingStateJ.getMemoryShareEnabled());
            C4148a.d(TAG, "Loaded cached setting: enabled=" + memorySettingStateJ.getMemoryShareEnabled() + ", version=" + memorySettingStateJ.getVersion(), false, 4, null);
        }
    }

    public final void P() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AmooMemoryFragment$loadMemorySetting$1(this, null), 3, null);
    }

    public final void W() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        final Dialog dialog = new Dialog(context, R.style.Theme.Translucent.NoTitleBar);
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.dialog_maintenance_confirm, (ViewGroup) null);
        dialog.setContentView(viewInflate);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
            window.setLayout(-1, -1);
        }
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        ((TextView) viewInflate.findViewById(R$id.tv_title)).setText(getString(R$string.memory_share_close_dialog_title));
        ((TextView) viewInflate.findViewById(R$id.tv_message)).setText(getString(R$string.memory_share_close_dialog_message));
        TextView textView = (TextView) viewInflate.findViewById(R$id.btn_cancel);
        textView.setText(getString(R$string.repair_dialog_cancel));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AmooMemoryFragment.X(dialog, view);
            }
        });
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.btn_confirm);
        textView2.setText(getString(R$string.repair_dialog_confirm));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AmooMemoryFragment.Y(dialog, this, view);
            }
        });
        View viewFindViewById = viewInflate.findViewById(R$id.fl_overlay);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AmooMemoryFragment.Z(dialog, view);
                }
            });
        }
        View viewFindViewById2 = viewInflate.findViewById(R$id.ll_card);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AmooMemoryFragment.a0(view);
                }
            });
        }
        dialog.show();
    }

    public final void b0(final boolean enabled) {
        this.isUpdating = true;
        N().switchMemoryShare.setChecked(enabled);
        MemorySettingApi.INSTANCE.G(enabled, this.currentVersion, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooMemoryFragment.c0(this.f29121a, enabled, (MemorySettingState) obj);
            }
        });
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this._binding = r6.e.a(view);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, false, 2, null);
        ImageView btnClose = N().btnClose;
        kotlin.jvm.internal.p.h(btnClose, "btnClose");
        C2773b6.p(c2773b6, new View[]{btnClose}, null, false, 6, null);
        Q();
        O();
        P();
    }
}
