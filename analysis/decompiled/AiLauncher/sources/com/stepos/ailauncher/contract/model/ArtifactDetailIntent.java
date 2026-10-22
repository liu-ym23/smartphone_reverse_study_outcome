package com.stepos.ailauncher.contract.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0005J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u000bJ\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000bJ\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/contract/model/ArtifactDetailIntent;", "", "<init>", "()V", "ACTION", "", "EXTRA_ARTIFACT", "EXTRA_RESTORE_WAKE_CHAT", "EXTRA_SOURCE", "SOURCE_CHATVIEW", "of", "Landroid/content/Intent;", "context", "Landroid/content/Context;", ArtifactDetailIntent.EXTRA_ARTIFACT, "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", ArtifactDetailIntent.EXTRA_RESTORE_WAKE_CHAT, "", "source", "artifactOf", "intent", "restoreWakeChatOf", "sourceOf", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArtifactDetailIntent {
    public static final String ACTION = "com.stepos.ailauncher.task.DETAIL_ACTION";
    private static final String EXTRA_ARTIFACT = "artifact";
    private static final String EXTRA_RESTORE_WAKE_CHAT = "restoreWakeChat";
    private static final String EXTRA_SOURCE = "source";
    public static final ArtifactDetailIntent INSTANCE = new ArtifactDetailIntent();
    public static final String SOURCE_CHATVIEW = "chatview";

    private ArtifactDetailIntent() {
    }

    public static /* synthetic */ Intent of$default(ArtifactDetailIntent artifactDetailIntent, Context context, SessionArtifact sessionArtifact, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        if ((i10 & 8) != 0) {
            str = "chatview";
        }
        return artifactDetailIntent.of(context, sessionArtifact, z10, str);
    }

    public final SessionArtifact artifactOf(Intent intent) {
        p.i(intent, "intent");
        return (SessionArtifact) intent.getParcelableExtra(EXTRA_ARTIFACT, SessionArtifact.class);
    }

    public final Intent of(Context context, SessionArtifact artifact, boolean restoreWakeChat, String source) {
        p.i(context, "context");
        p.i(artifact, "artifact");
        p.i(source, "source");
        Intent intent = new Intent(ACTION);
        intent.setPackage(context.getPackageName());
        intent.putExtra(EXTRA_ARTIFACT, artifact);
        intent.putExtra(EXTRA_RESTORE_WAKE_CHAT, restoreWakeChat);
        intent.putExtra("source", source);
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        return intent;
    }

    public final boolean restoreWakeChatOf(Intent intent) {
        p.i(intent, "intent");
        return intent.getBooleanExtra(EXTRA_RESTORE_WAKE_CHAT, false);
    }

    public final String sourceOf(Intent intent) {
        p.i(intent, "intent");
        String stringExtra = intent.getStringExtra("source");
        return stringExtra == null ? "chatview" : stringExtra;
    }
}
