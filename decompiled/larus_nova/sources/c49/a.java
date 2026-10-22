package c49;

import android.service.notification.StatusBarNotification;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f22415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f22417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f22418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f22419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f22420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f22421h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f22422i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f22423j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final StatusBarNotification f22424k;

    public final String toString() {
        if (AppHost.f326268a.isTestChannel() == false) goto L7;
        return "NLMsg{when=" + this.f22415b + ", pkg='" + this.f22416c + "', pkg_name='" + this.f22417d + "', title='" + this.f22418e + "', subTitle='" + this.f22419f + "', content='" + this.f22420g + "', channel='" + this.f22421h + "', category='" + this.f22422i + "', sbn=" + this.f22424k + '}';
    L7:
        return "NLMsg{when=" + this.f22415b + ", pkg='" + this.f22416c + "', pkg_name='" + this.f22417d + "', title='" + this.f22418e.length() + "', subTitle='" + this.f22419f.length() + "', content='" + this.f22420g.length() + "', channel='" + this.f22421h + "', category='" + this.f22422i + "', sbn=" + this.f22424k + '}';
    }

    public a(int r100, long r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, int r111, StatusBarNotification r112) {
        this.f22414a = r100;
        this.f22415b = r101;
        this.f22416c = r102;
        this.f22417d = r103;
        this.f22418e = r104;
        this.f22419f = r105;
        this.f22420g = r106;
        this.f22421h = r107;
        this.f22422i = r110;
        this.f22423j = r111;
        this.f22424k = r112;
    }
}
