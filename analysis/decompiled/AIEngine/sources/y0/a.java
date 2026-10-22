package y0;

import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.appcompat.widget.k;
import v0.c;
import v0.e0;
import y0.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.material.button.a f13963a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(InputConnection inputConnection, com.google.android.material.button.a aVar) {
        super(inputConnection, false);
        this.f13963a = aVar;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i10, Bundle bundle) {
        Bundle bundle2;
        c.b aVar;
        b bVar = inputContentInfo == null ? null : new b(new b.a(inputContentInfo));
        k kVar = (k) this.f13963a.f4761g;
        if ((i10 & 1) != 0) {
            try {
                bVar.f13964a.f13965a.requestPermission();
                InputContentInfo inputContentInfo2 = bVar.f13964a.f13965a;
                bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle2.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo2);
            } catch (Exception e10) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e10);
            }
        } else {
            bundle2 = bundle;
        }
        InputContentInfo inputContentInfo3 = bVar.f13964a.f13965a;
        ClipData clipData = new ClipData(inputContentInfo3.getDescription(), new ClipData.Item(inputContentInfo3.getContentUri()));
        if (Build.VERSION.SDK_INT >= 31) {
            aVar = new c.a(clipData, 2);
        } else {
            c.C0152c c0152c = new c.C0152c();
            c0152c.f13255a = clipData;
            c0152c.f13256b = 2;
            aVar = c0152c;
        }
        aVar.a(inputContentInfo3.getLinkUri());
        aVar.setExtras(bundle2);
        if (e0.g(kVar, aVar.build()) == null) {
            return true;
        }
        return super.commitContent(inputContentInfo, i10, bundle);
    }
}
