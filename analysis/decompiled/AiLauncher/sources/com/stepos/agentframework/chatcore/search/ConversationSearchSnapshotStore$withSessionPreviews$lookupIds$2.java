package com.stepos.agentframework.chatcore.search;

import La.r;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* synthetic */ class ConversationSearchSnapshotStore$withSessionPreviews$lookupIds$2 extends FunctionReferenceImpl implements InterfaceC5074l<String, Boolean> {
    public static final ConversationSearchSnapshotStore$withSessionPreviews$lookupIds$2 INSTANCE = new ConversationSearchSnapshotStore$withSessionPreviews$lookupIds$2();

    public ConversationSearchSnapshotStore$withSessionPreviews$lookupIds$2() {
        super(1, r.class, "isNotEmpty", "isNotEmpty(Ljava/lang/CharSequence;)Z", 1);
    }

    @Override // p9.InterfaceC5074l
    public final Boolean invoke(String p02) {
        kotlin.jvm.internal.p.i(p02, "p0");
        return Boolean.valueOf(p02.length() > 0);
    }
}
