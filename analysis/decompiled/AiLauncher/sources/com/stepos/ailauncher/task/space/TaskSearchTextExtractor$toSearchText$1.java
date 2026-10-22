package com.stepos.ailauncher.task.space;

import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class TaskSearchTextExtractor$toSearchText$1 extends FunctionReferenceImpl implements InterfaceC5074l<String, String> {
    public TaskSearchTextExtractor$toSearchText$1(Object obj) {
        super(1, obj, TaskSearchTextExtractor.class, "sanitizeText", "sanitizeText(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    @Override // p9.InterfaceC5074l
    public final String invoke(String p02) {
        kotlin.jvm.internal.p.i(p02, "p0");
        return ((TaskSearchTextExtractor) this.receiver).t(p02);
    }
}
