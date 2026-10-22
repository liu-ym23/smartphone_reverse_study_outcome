package ala;

import android.net.Uri;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public interface e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4209a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f4210a = null;

        static {
            f4210a = new a();
        }

        public a() {
        }

        public static String a(e r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            if ((r100 instanceof ala.a) == false) goto L6;
            return "Calendars";
        L6:
            if ((r100 instanceof b) == false) goto L8;
        L15:
            return "Events";
        L8:
            if ((r100 instanceof c) == true) goto L15;
            if ((r100 instanceof d) == false) goto L14;
            return "Reminders";
        L14:
            throw new NotImplementedError(null, 1, null);
        }
    }

    static {
        f4209a = a.f4210a;
    }

    Long getId();

    Uri toUri();
}
