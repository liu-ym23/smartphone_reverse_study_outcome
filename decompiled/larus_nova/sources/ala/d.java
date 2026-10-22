package ala;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.CalendarContract;
import com.obric.miniapp.alarm.AccountType;

/* JADX INFO: loaded from: classes33.dex */
public final class d implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f4207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4208c;

    public static final class a {
    }

    static {
    }

    @Override // ala.e
    public final Uri toUri() {
        Uri.Builder r100 = CalendarContract.Reminders.CONTENT_URI.buildUpon();
        Long r101 = this.f4207b;
        if (r101 == null) goto L6;
        ContentUris.appendId(r100, r101.longValue());
    L6:
        if (this.f4208c == null) goto L9;
        r100.appendQueryParameter("caller_is_syncadapter", "true");
        r100.appendQueryParameter("account_name", this.f4208c);
        r100.appendQueryParameter("account_type", AccountType.LOCAL);
    L9:
        return r100.build();
    }

    @Override // ala.e
    public final Long getId() {
        return this.f4207b;
    }

    public /* synthetic */ d(Long r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, null);
    }

    public d(Long r100, String r101) {
        this.f4207b = r100;
        this.f4208c = r101;
    }
}
