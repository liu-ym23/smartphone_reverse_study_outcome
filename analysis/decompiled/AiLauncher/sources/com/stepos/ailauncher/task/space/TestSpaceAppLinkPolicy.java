package com.stepos.ailauncher.task.space;

import Z8.C1174w;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import java.math.BigInteger;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/task/space/TestSpaceAppLinkPolicy;", "", "<init>", "()V", "", "isInstalled", "", "url", "serverVersion", "installedVersion", "Lcom/stepos/ailauncher/task/space/TestSpaceAppLinkPolicy$Action;", Const.INTENT_KEY_APIKEY, "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/task/space/TestSpaceAppLinkPolicy$Action;", "server", "installed", "c", "(Ljava/lang/String;Ljava/lang/String;)Z", "appType", "e", "(Ljava/lang/String;)Z", Const.INTENT_KEY_PKGNAME, "f", "(Ljava/lang/String;)Ljava/lang/String;", "Action", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TestSpaceAppLinkPolicy {
    public static final TestSpaceAppLinkPolicy INSTANCE = new TestSpaceAppLinkPolicy();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/task/space/TestSpaceAppLinkPolicy$Action;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN", "DOWNLOAD", "DOWNLOAD_UNAVAILABLE", "UPDATE", "UPDATE_UNAVAILABLE", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Action {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Action[] $VALUES;
        public static final Action OPEN = new Action("OPEN", 0);
        public static final Action DOWNLOAD = new Action("DOWNLOAD", 1);
        public static final Action DOWNLOAD_UNAVAILABLE = new Action("DOWNLOAD_UNAVAILABLE", 2);
        public static final Action UPDATE = new Action("UPDATE", 3);
        public static final Action UPDATE_UNAVAILABLE = new Action("UPDATE_UNAVAILABLE", 4);

        private static final /* synthetic */ Action[] $values() {
            return new Action[]{OPEN, DOWNLOAD, DOWNLOAD_UNAVAILABLE, UPDATE, UPDATE_UNAVAILABLE};
        }

        static {
            Action[] actionArr$values = $values();
            $VALUES = actionArr$values;
            $ENTRIES = kotlin.enums.a.a(actionArr$values);
        }

        private Action(String str, int i10) {
        }

        public static InterfaceC4149a<Action> getEntries() {
            return $ENTRIES;
        }

        public static Action valueOf(String str) {
            return (Action) Enum.valueOf(Action.class, str);
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }
    }

    public static final List<BigInteger> d(String str) {
        String string;
        String strR0;
        String strR02;
        ArrayList arrayList = null;
        if (str != null && (string = La.H.D1(str).toString()) != null && (strR0 = La.H.R0(string, "v")) != null && (strR02 = La.H.R0(strR0, ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) != null) {
            if (!new Regex("[0-9]+(?:\\.[0-9]+)*").k(strR02)) {
                return null;
            }
            List listA1 = La.H.a1(strR02, new char[]{'.'}, false, 0, 6, null);
            arrayList = new ArrayList(C1174w.x(listA1, 10));
            Iterator it = listA1.iterator();
            while (it.hasNext()) {
                arrayList.add(new BigInteger((String) it.next()));
            }
        }
        return arrayList;
    }

    public final Action a(boolean isInstalled, String url, String serverVersion, String installedVersion) {
        kotlin.jvm.internal.p.i(url, "url");
        return (isInstalled && c(serverVersion, installedVersion)) ? f(url) != null ? Action.UPDATE : Action.UPDATE_UNAVAILABLE : isInstalled ? Action.OPEN : f(url) != null ? Action.DOWNLOAD : Action.DOWNLOAD_UNAVAILABLE;
    }

    public final boolean b(String appType) {
        kotlin.jvm.internal.p.i(appType, "appType");
        return La.D.L(La.H.D1(appType).toString(), "game", true);
    }

    public final boolean c(String server, String installed) {
        List<BigInteger> listD;
        List<BigInteger> listD2 = d(server);
        if (listD2 == null || (listD = d(installed)) == null) {
            return false;
        }
        int iMax = Math.max(listD2.size(), listD.size());
        for (int i10 = 0; i10 < iMax; i10++) {
            BigInteger bigInteger = (BigInteger) Z8.F.t0(listD2, i10);
            if (bigInteger == null) {
                bigInteger = BigInteger.ZERO;
            }
            BigInteger bigInteger2 = (BigInteger) Z8.F.t0(listD, i10);
            if (bigInteger2 == null) {
                bigInteger2 = BigInteger.ZERO;
            }
            int iCompareTo = bigInteger.compareTo(bigInteger2);
            if (iCompareTo != 0) {
                return iCompareTo > 0;
            }
        }
        return false;
    }

    public final boolean e(String appType) {
        kotlin.jvm.internal.p.i(appType, "appType");
        return La.D.L(La.H.D1(appType).toString(), "app", true);
    }

    public final String f(String url) {
        Object objB;
        String host;
        kotlin.jvm.internal.p.i(url, "url");
        String string = La.H.D1(url).toString();
        if (string.length() <= 0) {
            string = null;
        }
        if (string == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(new URI(string));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        URI uri = (URI) objB;
        if (uri == null) {
            return null;
        }
        if ((!La.D.L(uri.getScheme(), "https", true) && !La.D.L(uri.getScheme(), "http", true)) || (host = uri.getHost()) == null || La.H.x0(host)) {
            return null;
        }
        return string;
    }
}
