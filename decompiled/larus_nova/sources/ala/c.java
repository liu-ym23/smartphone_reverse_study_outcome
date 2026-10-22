package ala;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.CalendarContract;
import com.obric.miniapp.alarm.AccountType;

/* JADX INFO: loaded from: classes33.dex */
public final class c implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4206c;

    @Override // ala.e
    public final Long getId() {
        return Long.valueOf(this.f4205b);
    }

    @Override // ala.e
    public final Uri toUri() {
        Uri.Builder r100 = CalendarContract.Events.CONTENT_EXCEPTION_URI.buildUpon();
        ContentUris.appendId(r100, this.f4205b).appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", this.f4206c).appendQueryParameter("account_type", AccountType.LOCAL);
        return r100.build();
    }

    public c(long r100, String r101) {
        this.f4205b = r100;
        this.f4206c = r101;
    }
}
