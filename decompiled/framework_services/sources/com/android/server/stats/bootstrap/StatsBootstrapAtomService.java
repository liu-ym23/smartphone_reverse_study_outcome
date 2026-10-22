package com.android.server.stats.bootstrap;

import android.content.Context;
import android.os.IStatsBootstrapAtomService;
import android.os.StatsBootstrapAtom;
import android.os.StatsBootstrapAtomValue;
import android.util.Slog;
import android.util.StatsEvent;
import android.util.StatsLog;
import com.android.server.SystemService;

/* JADX INFO: loaded from: classes3.dex */
public class StatsBootstrapAtomService extends IStatsBootstrapAtomService.Stub {
    private static final boolean DEBUG = false;
    private static final String TAG = "StatsBootstrapAtomService";

    public static final class Lifecycle extends SystemService {
        private StatsBootstrapAtomService mStatsBootstrapAtomService;

        public Lifecycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            this.mStatsBootstrapAtomService = new StatsBootstrapAtomService();
            publishBinderService("statsbootstrap", this.mStatsBootstrapAtomService);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Slog.e(StatsBootstrapAtomService.TAG, "Failed to publishBinderService", e);
        }
    }

    public StatsBootstrapAtomService() {
    }

    public void reportBootstrapAtom(StatsBootstrapAtom atom) {
        byte r3 = 1;
        if (atom.atomId >= 1) goto L5;
    L35:
        Slog.e(TAG, "Atom ID " + atom.atomId + " is not a valid atom ID");
        return;
    L5:
        if (atom.atomId >= 10000) goto L35;
        StatsEvent.Builder builder = StatsEvent.newBuilder().setAtomId(atom.atomId);
        StatsBootstrapAtomValue[] r4 = atom.values;
        int r5 = r4.length;
        int r7 = 0;
    L8:
        if (r7 >= r5) goto L33;
        StatsBootstrapAtomValue atomValue = r4[r7];
        StatsBootstrapAtomValue.Primitive value = atomValue.value;
        switch(value.getTag()) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L11;
        };
    L13:
        builder.writeStringArray(value.getStringArrayValue());
    L20:
        StatsBootstrapAtomValue.Annotation[] r10 = atomValue.annotations;
        StatsBootstrapAtomValue.Annotation[] r12 = atomValue.annotations;
        int r13 = r12.length;
        int r14 = 0;
    L22:
        if (r14 >= r13) goto L32;
        StatsBootstrapAtomValue.Annotation annotation = r12[r14];
        if (annotation.id != r3) goto L25;
        switch(annotation.value.getTag()) {
            case 0: goto L31;
            default: goto L29;
        };
    L31:
        builder.addBooleanAnnotation(annotation.id, annotation.value.getBoolValue());
        r14 = r14 + 1;
        r3 = 1;
        goto L22
    L29:
        Slog.e(TAG, "Unexpected value type " + annotation.value.getTag() + " when logging UID for atom " + atom.atomId);
        return;
    L25:
        Slog.e(TAG, "Unexpected annotation ID: " + annotation.id + ", for atom " + atom.atomId + ": only UIDs are supported!");
        return;
    L32:
        r7 = r7 + 1;
        r3 = 1;
        goto L8
    L14:
        builder.writeByteArray(value.getBytesValue());
        goto L20
    L15:
        builder.writeString(value.getStringValue());
        goto L20
    L16:
        builder.writeFloat(value.getFloatValue());
        goto L20
    L17:
        builder.writeLong(value.getLongValue());
        goto L20
    L18:
        builder.writeInt(value.getIntValue());
        goto L20
    L19:
        builder.writeBoolean(value.getBoolValue());
        goto L20
    L11:
        Slog.e(TAG, "Unexpected value type " + value.getTag() + " when logging atom " + atom.atomId);
        return;
    L33:
        StatsLog.write(builder.usePooledBuffer().build());
    }
}
