package org.yaml.snakeyaml.comments;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class CommentType {

    /* renamed from: a, reason: collision with root package name */
    public static final CommentType f5522a;
    public static final CommentType b;
    public static final CommentType c;
    public static final /* synthetic */ CommentType[] d;

    static {
        CommentType commentType = new CommentType("BLANK_LINE", 0);
        f5522a = commentType;
        CommentType commentType2 = new CommentType("BLOCK", 1);
        b = commentType2;
        CommentType commentType3 = new CommentType("IN_LINE", 2);
        c = commentType3;
        d = new CommentType[]{commentType, commentType2, commentType3};
    }

    public static CommentType valueOf(String str) {
        return (CommentType) Enum.valueOf(CommentType.class, str);
    }

    public static CommentType[] values() {
        return (CommentType[]) d.clone();
    }
}
