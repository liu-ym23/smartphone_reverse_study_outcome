package b9c;

import com.bytedance.lark.pb.basic.v1.Command;
import com.ss.android.lark.maintab.export.MainTabRegister;
import com.ss.android.lark.maintab.export.c;
import com.ss.android.lark.todo.impl.features.remind.reminder.d;

/* JADX INFO: loaded from: classes38.dex */
@MainTabRegister
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18375a;

    public a() {
        if (this.f18375a == true) goto L7;
        this.f18375a = true;
        d r100 = new d();
        r100.f443950b = new r8c.a(r100);
        com.ss.android.lark.todo.impl.rustadapter.push.c.f444233a.a(Command.PUSH_TODO_REMINDER_NOTIFICATION, r100.f443950b);
        return;
    }
}
