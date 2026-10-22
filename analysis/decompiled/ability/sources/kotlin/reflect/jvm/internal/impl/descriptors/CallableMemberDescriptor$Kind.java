package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class CallableMemberDescriptor$Kind {

    /* renamed from: a, reason: collision with root package name */
    public static final CallableMemberDescriptor$Kind f4950a;
    public static final CallableMemberDescriptor$Kind b;
    public static final CallableMemberDescriptor$Kind c;
    public static final CallableMemberDescriptor$Kind d;
    public static final /* synthetic */ CallableMemberDescriptor$Kind[] e;

    static {
        CallableMemberDescriptor$Kind callableMemberDescriptor$Kind = new CallableMemberDescriptor$Kind("DECLARATION", 0);
        f4950a = callableMemberDescriptor$Kind;
        CallableMemberDescriptor$Kind callableMemberDescriptor$Kind2 = new CallableMemberDescriptor$Kind("FAKE_OVERRIDE", 1);
        b = callableMemberDescriptor$Kind2;
        CallableMemberDescriptor$Kind callableMemberDescriptor$Kind3 = new CallableMemberDescriptor$Kind("DELEGATION", 2);
        c = callableMemberDescriptor$Kind3;
        CallableMemberDescriptor$Kind callableMemberDescriptor$Kind4 = new CallableMemberDescriptor$Kind("SYNTHESIZED", 3);
        d = callableMemberDescriptor$Kind4;
        e = new CallableMemberDescriptor$Kind[]{callableMemberDescriptor$Kind, callableMemberDescriptor$Kind2, callableMemberDescriptor$Kind3, callableMemberDescriptor$Kind4};
    }

    public static CallableMemberDescriptor$Kind valueOf(String str) {
        return (CallableMemberDescriptor$Kind) Enum.valueOf(CallableMemberDescriptor$Kind.class, str);
    }

    public static CallableMemberDescriptor$Kind[] values() {
        return (CallableMemberDescriptor$Kind[]) e.clone();
    }
}
