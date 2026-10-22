package X;

import K.C0073e;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import com.stepos.common.widget.SearchEditText;
import com.stepos.renderfilter.RenderFilter;

/* loaded from: classes.dex */
public final class v extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2091a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2092b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(Object obj, Handler handler, int i4) {
        super(handler);
        this.f2091a = i4;
        this.f2092b = obj;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z4) {
        switch (this.f2091a) {
            case 1:
                SearchEditText searchEditText = (SearchEditText) this.f2092b;
                int i4 = SearchEditText.f11774g;
                searchEditText.a(false);
                break;
            default:
                super.onChange(z4);
                break;
        }
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z4, Uri uri) {
        Boolean boolValueOf;
        int i4 = this.f2091a;
        Object obj = this.f2092b;
        switch (i4) {
            case 0:
                ((w) obj).c();
                break;
            case 1:
            default:
                super.onChange(z4, uri);
                break;
            case 2:
                if (uri != null) {
                    com.google.android.gms.common.api.internal.s sVar = (com.google.android.gms.common.api.internal.s) obj;
                    if (uri.equals((Uri) sVar.f9681c)) {
                        C2.g gVar = (C2.g) sVar.f9683e;
                        try {
                            boolean z5 = true;
                            if (Settings.Global.getInt(((Context) sVar.f9680b).getContentResolver(), (String) sVar.f9682d) != 1) {
                                z5 = false;
                            }
                            boolValueOf = Boolean.valueOf(z5);
                        } catch (Settings.SettingNotFoundException unused) {
                            boolValueOf = Boolean.valueOf(sVar.f9679a);
                        }
                        switch (((C0073e) gVar).f958a) {
                            case 9:
                                RenderFilter.f12294e = boolValueOf.booleanValue();
                                break;
                            case 10:
                                RenderFilter.f12295f = boolValueOf.booleanValue();
                                break;
                            default:
                                RenderFilter.f12296g = boolValueOf.booleanValue();
                                break;
                        }
                    }
                }
                break;
        }
    }
}
