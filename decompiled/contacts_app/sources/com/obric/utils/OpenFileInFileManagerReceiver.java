package com.obric.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.android.contacts.R;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: OpenFileInFileManagerReceiver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/utils/OpenFileInFileManagerReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OpenFileInFileManagerReceiver extends BroadcastReceiver {
    public static final Companion Companion = null;
    public static final String INTENT_FILE_PATH = "contacts_vcf_path";

    /* JADX INFO: compiled from: OpenFileInFileManagerReceiver.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/utils/OpenFileInFileManagerReceiver$Companion;", "", "()V", "INTENT_FILE_PATH", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OpenFileInFileManagerReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r2, Intent r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 == null) goto L18;
        String r1 = r3.getStringExtra(INTENT_FILE_PATH);
        if (r1 == null) goto L20;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L10
        Intent r5 = new Intent("com.bytedance.action.VIEW_FOLDER");     // Catch: Throwable -> L10
        r5.setPackage("com.obric.filemanager");     // Catch: Throwable -> L10
        r5.putExtra("path", r1);     // Catch: Throwable -> L10
        r5.addFlags(32768);     // Catch: Throwable -> L10
        r5.addFlags(268435456);     // Catch: Throwable -> L10
        r2.startActivity(r5);     // Catch: Throwable -> L10
        Object r6 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L13:
        if (Result.m806exceptionOrNullimpl(r6) == null) goto L19;
        Toast.makeText(r2, R.string.vcf_file_export_fail_file_not_install, 0).show();
        return;
    L19:
        return;
    L10:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L13
    L20:
        return;
    }
}
