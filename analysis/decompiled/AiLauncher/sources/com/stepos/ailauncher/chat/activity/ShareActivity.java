package com.stepos.ailauncher.chat.activity;

import Ua.C1060i;
import Z8.C1172u;
import Z8.C1173v;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.C1398p;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.wake.WakeService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import l9.C4877a;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\r\u0010\fJ'\u0010\u0013\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0015\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J!\u0010\u0019\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010 \u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010!J\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\"\u0010#J\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b$\u0010#¨\u0006'"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/ShareActivity;", "Lz5/a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "z", "", "text", "", "Landroid/net/Uri;", "uris", "C", "(Ljava/lang/String;Ljava/util/List;)V", "D", "uri", "Ljava/io/File;", "intakeDir", "w", "(Landroid/net/Uri;Ljava/io/File;)Landroid/net/Uri;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroid/net/Uri;)Ljava/lang/String;", "", "B", "(Landroid/net/Uri;)J", "x", "(Landroid/content/Intent;)Ljava/lang/String;", "y", "(Landroid/content/Intent;)Ljava/util/List;", "v", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ShareActivity extends ActivityC6361a {
    private static final long MAX_FILE_SIZE_BYTES = 5242880;
    private static final long MAX_IMAGE_SIZE_BYTES = 15728640;
    private static final String TAG = "ShareActivity";

    /* JADX WARN: Removed duplicated region for block: B:34:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String A(android.net.Uri r9) {
        /*
            r8 = this;
            r1 = 0
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L41
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L41
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            r3 = r9
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L32
            if (r8 == 0) goto L3b
            java.io.Closeable r8 = (java.io.Closeable) r8     // Catch: java.lang.Throwable -> L32
            r9 = r8
            android.database.Cursor r9 = (android.database.Cursor) r9     // Catch: java.lang.Throwable -> L2a
            java.lang.String r0 = "_display_name"
            int r0 = r9.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L2a
            if (r0 < 0) goto L2d
            boolean r2 = r9.moveToFirst()     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto L2d
            java.lang.String r9 = r9.getString(r0)     // Catch: java.lang.Throwable -> L2a
            goto L2e
        L2a:
            r0 = move-exception
            r9 = r0
            goto L35
        L2d:
            r9 = r1
        L2e:
            l9.b.a(r8, r1)     // Catch: java.lang.Throwable -> L32
            goto L3c
        L32:
            r0 = move-exception
        L33:
            r8 = r0
            goto L44
        L35:
            throw r9     // Catch: java.lang.Throwable -> L36
        L36:
            r0 = move-exception
            l9.b.a(r8, r9)     // Catch: java.lang.Throwable -> L32
            throw r0     // Catch: java.lang.Throwable -> L32
        L3b:
            r9 = r1
        L3c:
            java.lang.Object r8 = kotlin.Result.b(r9)     // Catch: java.lang.Throwable -> L32
            goto L4e
        L41:
            r0 = move-exception
            r3 = r9
            goto L33
        L44:
            kotlin.Result$a r9 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.C4849c.a(r8)
            java.lang.Object r8 = kotlin.Result.b(r8)
        L4e:
            boolean r9 = kotlin.Result.g(r8)
            if (r9 == 0) goto L55
            goto L56
        L55:
            r1 = r8
        L56:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L5e
            java.lang.String r1 = r3.getLastPathSegment()
        L5e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.activity.ShareActivity.A(android.net.Uri):java.lang.String");
    }

    public final long B(Uri uri) {
        Object objB;
        long j10;
        try {
            Result.Companion companion = Result.INSTANCE;
            Cursor cursorQuery = getContentResolver().query(uri, new String[]{"_size"}, null, null, null);
            if (cursorQuery != null) {
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    int columnIndex = cursor2.getColumnIndex("_size");
                    j10 = (columnIndex < 0 || !cursor2.moveToFirst()) ? -1L : cursor2.getLong(columnIndex);
                    l9.b.a(cursor, null);
                } finally {
                }
            } else {
                j10 = -1;
            }
            objB = Result.b(Long.valueOf(j10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = -1L;
        }
        return ((Number) objB).longValue();
    }

    public final void C(String text, List<? extends Uri> uris) {
        C1060i.d(C1398p.a(this), null, null, new ShareActivity$stageSharedFilesAndWake$1(uris, getApplicationContext(), this, text, null), 3, null);
    }

    public final void D(String text, List<? extends Uri> uris) {
        if (com.stepos.ailauncher.foundation.account.f.INSTANCE.v()) {
            AuthManager authManager = AuthManager.INSTANCE;
            if (authManager.Y() && authManager.K() && authManager.e0()) {
                com.stepos.ailauncher.chat.manager.S0.INSTANCE.a("gates_ready");
                return;
            }
        }
        com.stepos.ailauncher.chat.manager.S0.INSTANCE.e(text, uris);
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b.w.b(this, null, null, 3, null);
        setContentView(R$layout.activity_share);
        z(getIntent());
    }

    @Override // b.q, android.app.Activity
    public void onNewIntent(Intent intent) {
        kotlin.jvm.internal.p.i(intent, "intent");
        super.onNewIntent(intent);
        z(intent);
    }

    public final List<Uri> v(Intent intent) {
        Uri uri;
        ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return C1173v.m();
        }
        ArrayList arrayList = new ArrayList(clipData.getItemCount());
        int itemCount = clipData.getItemCount();
        for (int i10 = 0; i10 < itemCount; i10++) {
            ClipData.Item itemAt = clipData.getItemAt(i10);
            if (itemAt != null && (uri = itemAt.getUri()) != null) {
                arrayList.add(uri);
            }
        }
        return arrayList;
    }

    public final Uri w(Uri uri, File intakeDir) {
        Object objB;
        String strA = A(uri);
        if (strA == null) {
            strA = "share_" + System.currentTimeMillis();
        }
        File file = new File(intakeDir, System.currentTimeMillis() + "_" + strA);
        try {
            Result.Companion companion = Result.INSTANCE;
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            boolean z10 = false;
            if (inputStreamOpenInputStream != null) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        C4877a.b(inputStreamOpenInputStream, fileOutputStream, 0, 2, null);
                        l9.b.a(fileOutputStream, null);
                        l9.b.a(inputStreamOpenInputStream, null);
                        z10 = true;
                    } finally {
                    }
                } finally {
                }
            }
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "copyUriToIntake: failed " + uri, thE);
            objB = Boolean.FALSE;
        }
        if (((Boolean) objB).booleanValue()) {
            return Uri.fromFile(file);
        }
        return null;
    }

    public final String x(Intent intent) {
        String type;
        if (!kotlin.jvm.internal.p.d(intent.getAction(), "android.intent.action.SEND") || (type = intent.getType()) == null || !La.D.X(type, "text/", false, 2, null)) {
            return null;
        }
        String stringExtra = intent.getStringExtra("android.intent.extra.TEXT");
        if (stringExtra != null) {
            return stringExtra;
        }
        CharSequence charSequenceExtra = intent.getCharSequenceExtra("android.intent.extra.TEXT");
        if (charSequenceExtra != null) {
            return charSequenceExtra.toString();
        }
        return null;
    }

    public final List<Uri> y(Intent intent) {
        List<Uri> listM1;
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != -1173264947) {
                if (iHashCode == -58484670 && action.equals("android.intent.action.SEND_MULTIPLE")) {
                    ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM", Uri.class);
                    return (parcelableArrayListExtra == null || (listM1 = Z8.F.m1(parcelableArrayListExtra)) == null) ? v(intent) : listM1;
                }
            } else if (action.equals("android.intent.action.SEND")) {
                Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM", Uri.class);
                return uri != null ? C1172u.e(uri) : v(intent);
            }
        }
        return C1173v.m();
    }

    public final void z(Intent intent) {
        if (intent == null) {
            finish();
            return;
        }
        String strX = x(intent);
        List<Uri> listY = y(intent);
        String action = intent.getAction();
        String type = intent.getType();
        String strR1 = strX != null ? La.K.R1(strX, 40) : null;
        Log.d(TAG, "handleShareIntent action=" + action + " type=" + type + " text=" + strR1 + " uriCount=" + listY.size());
        if ((strX == null || La.H.x0(strX)) && listY.isEmpty()) {
            Log.d(TAG, "handleShareIntent: empty payload, skip wake");
            finish();
        } else {
            if (!listY.isEmpty()) {
                C(strX, listY);
                return;
            }
            D(strX, C1173v.m());
            WakeService.Companion companion = WakeService.INSTANCE;
            Context applicationContext = getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            companion.K1(applicationContext, strX, C1173v.m());
            finish();
        }
    }
}
