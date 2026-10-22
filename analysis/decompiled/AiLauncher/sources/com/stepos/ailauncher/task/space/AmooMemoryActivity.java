package com.stepos.ailauncher.task.space;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.sheet.C2739j;
import com.stepos.ailauncher.sheet.SheetExitAnim;
import com.stepos.ailauncher.task.R$drawable;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001b\u0010\fJ\u000f\u0010\u001c\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001c\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/task/space/AmooMemoryActivity;", "Lcom/stepos/ailauncher/sheet/S;", "<init>", "()V", "Landroidx/fragment/app/Fragment;", "s4", "()Landroidx/fragment/app/Fragment;", "", "f4", "()Ljava/lang/String;", "", "Z3", "()Z", "Lcom/stepos/ailauncher/sheet/SheetExitAnim;", "x1", "()Lcom/stepos/ailauncher/sheet/SheetExitAnim;", "i1", "j1", "t3", "", "j2", "()I", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "y4", "(Landroid/os/Bundle;)V", "O2", "N2", "Companion", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmooMemoryActivity extends com.stepos.ailauncher.sheet.S {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/task/space/AmooMemoryActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.AmooMemoryActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            C2739j.C(context, new Intent(context, (Class<?>) AmooMemoryActivity.class), null, 4, null);
        }

        public Companion() {
        }
    }

    public static final Y8.t D4(AmooMemoryActivity amooMemoryActivity) {
        amooMemoryActivity.t4().B();
        return Y8.t.f7040a;
    }

    public static final Y8.t E4(AmooMemoryActivity amooMemoryActivity) throws Resources.NotFoundException {
        amooMemoryActivity.g1();
        return Y8.t.f7040a;
    }

    @Override // com.stepos.ailauncher.sheet.S, com.stepos.ailauncher.sheet.O
    public boolean N2() {
        android.view.W w10 = t4().w();
        com.stepos.ailauncher.sheet.nav.d dVar = w10 instanceof com.stepos.ailauncher.sheet.nav.d ? (com.stepos.ailauncher.sheet.nav.d) w10 : null;
        if (dVar == null || !dVar.l(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.l
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AmooMemoryActivity.D4(this.f29053a);
            }
        })) {
            return super.N2();
        }
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean O2() {
        android.view.W w10 = t4().w();
        com.stepos.ailauncher.sheet.nav.d dVar = w10 instanceof com.stepos.ailauncher.sheet.nav.d ? (com.stepos.ailauncher.sheet.nav.d) w10 : null;
        return dVar != null && dVar.l(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.k
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AmooMemoryActivity.E4(this.f29048a);
            }
        });
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean Z3() {
        return false;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public String f4() {
        String name = AmooMemoryActivity.class.getName();
        kotlin.jvm.internal.p.h(name, "getName(...)");
        return name;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean i1() {
        return false;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean j1() {
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public int j2() {
        if (get_layerIndex() > 1) {
            return 0;
        }
        return super.j2();
    }

    @Override // com.stepos.ailauncher.sheet.S
    public Fragment s4() {
        return new AmooMemoryFragment();
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean t3() {
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public SheetExitAnim x1() {
        return SheetExitAnim.SLIDE_DOWN;
    }

    @Override // com.stepos.ailauncher.sheet.S
    public void y4(Bundle savedInstanceState) {
        M1().setPadding(0, 0, 0, M1().getPaddingBottom());
        Y1().setBackgroundResource(R$drawable.bg_repair_panel);
    }
}
