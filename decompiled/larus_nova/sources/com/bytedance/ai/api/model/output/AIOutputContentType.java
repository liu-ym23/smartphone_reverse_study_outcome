package com.bytedance.ai.api.model.output;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/api/model/output/AIOutputContentType;", "", "<init>", "(Ljava/lang/String;I)V", CardAdapter.TEXT, "WIDGET", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AIOutputContentType extends Enum<AIOutputContentType> {
    public static final AIOutputContentType TEXT = null;
    public static final AIOutputContentType WIDGET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AIOutputContentType[] f34044a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34045b = null;

    public static EnumEntries<AIOutputContentType> getEntries() {
        return f34045b;
    }

    static {
        AIOutputContentType r100 = new AIOutputContentType(CardAdapter.TEXT, 0);
        TEXT = r100;
        AIOutputContentType r101 = new AIOutputContentType("WIDGET", 1);
        WIDGET = r101;
        AIOutputContentType[] r102 = {r100, r101};
        f34044a = r102;
        f34045b = EnumEntriesKt.enumEntries(r102);
    }

    public static AIOutputContentType[] values() {
        return (AIOutputContentType[]) f34044a.clone();
    }

    public static AIOutputContentType valueOf(String r100) {
        return (AIOutputContentType) a.a(AIOutputContentType.class, r100);
    }

    public AIOutputContentType(String r100, int r101) {
        super(r100, r101);
    }
}
