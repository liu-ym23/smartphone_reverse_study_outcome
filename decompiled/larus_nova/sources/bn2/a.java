package bn2;

import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.livesdk.dislike.NotificationSettingBottomDialog;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements NotificationSettingBottomDialog.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<fz.a> f19705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, fz.a> f19706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC0318a f19707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f19709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f19710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f19711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f19712h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final fz.b f19713i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final fz.b f19714j;

    /* JADX INFO: renamed from: bn2.a$a, reason: collision with other inner class name */
    public interface InterfaceC0318a {
        void a(List<? extends fz.a> r100, boolean r101, boolean r102);

        void b(List<? extends fz.a> r100, boolean r101);
    }

    @Override // com.bytedance.android.livesdk.dislike.NotificationSettingBottomDialog.b
    public final void onFailure() {
    }

    public a() {
        this.f19705a = new ArrayList();
        this.f19706b = new HashMap();
        this.f19710f = 30;
        this.f19713i = new fz.b("接收全部开播通知");
        this.f19714j = new fz.b("关闭通知");
    }

    public final void a(cn2.a r100, boolean r101) {
        int r102 = this.f19711g;
        if (r102 != 0) goto L5;
        ListProtector.add(this.f19705a, 0, r100);
        ListProtector.add(this.f19705a, 0, this.f19713i);
    L8:
        this.f19706b.put(r100.d(), r100);
        this.f19711g++;
        return;
    L5:
        if (r101 == false) goto L7;
        ListProtector.add(this.f19705a, 1, r100);
        goto L8
    L7:
        ListProtector.add(this.f19705a, r102 + 1, r100);
        goto L8
    }

    public final void b(cn2.a r100, boolean r101) {
        if (this.f19712h != 0) goto L6;
        this.f19705a.add(this.f19714j);
    L6:
        if (r101 == false) goto L12;
        int r102 = this.f19711g;
        if (r102 <= 0) goto L10;
        int r103 = 1;
    L11:
        ListProtector.add(this.f19705a, (r102 + r103) + 1, r100);
    L13:
        this.f19706b.put(r100.d(), r100);
        this.f19712h++;
        return;
    L10:
        r103 = 0;
        goto L11
    L12:
        this.f19705a.add(r100);
        goto L13
    }

    @Override // com.bytedance.android.livesdk.dislike.NotificationSettingBottomDialog.b
    public final void onSuccess(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "anchorId");
        fz.a r102 = this.f19706b.get(r100);
        if (r102 != null) goto L6;
        return;
    L6:
        if ((r102 instanceof cn2.a) == false) goto L38;
        cn2.a r103 = (cn2.a) r102;
        FollowInfo r104 = r103.b();
        if (r104 != null) goto L10;
    L12:
        FollowInfo r105 = r103.b();
        if (r105 != null) goto L15;
    L19:
        FollowInfo r106 = r103.b();
        if (r106 != null) goto L22;
    L26:
        FollowInfo r107 = r103.b();
        if (r107 == null) goto L30;
        r107.setPushStatus(r101);
    L30:
        if (r101 != 1) goto L33;
        a(r103, true);
    L36:
        if (this.f19705a.size() != 0) goto L38;
        j.f19729d.update(false);
        goto L38
    L33:
        if (r101 != 3) goto L36;
        b(r103, true);
        goto L36
    L22:
        if (r106.getPushStatus() != 3) goto L26;
        this.f19705a.remove(r103);
        this.f19706b.remove(r103.d());
        int r108 = this.f19712h - 1;
        this.f19712h = r108;
        if (r108 != 0) goto L26;
        this.f19705a.remove(this.f19714j);
        goto L26
    L15:
        if (r105.getPushStatus() != 1) goto L19;
        this.f19705a.remove(r103);
        this.f19706b.remove(r103.d());
        int r109 = this.f19711g - 1;
        this.f19711g = r109;
        if (r109 != 0) goto L26;
        this.f19705a.remove(this.f19713i);
        goto L26
    L10:
        if (r104.getPushStatus() != r101) goto L12;
        return;
    L38:
        InterfaceC0318a r110 = this.f19707c;
        if (r110 == null) goto L42;
        r110.b(this.f19705a, this.f19709e);
        return;
    }
}
