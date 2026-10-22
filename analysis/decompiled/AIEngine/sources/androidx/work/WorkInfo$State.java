package androidx.work;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class WorkInfo$State {

    /* renamed from: a, reason: collision with root package name */
    public static final WorkInfo$State f2792a;

    /* renamed from: b, reason: collision with root package name */
    public static final WorkInfo$State f2793b;

    /* renamed from: c, reason: collision with root package name */
    public static final WorkInfo$State f2794c;

    /* renamed from: d, reason: collision with root package name */
    public static final WorkInfo$State f2795d;

    /* renamed from: e, reason: collision with root package name */
    public static final WorkInfo$State f2796e;
    public static final WorkInfo$State h;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ WorkInfo$State[] f2797j;

    static {
        WorkInfo$State workInfo$State = new WorkInfo$State("ENQUEUED", 0);
        f2792a = workInfo$State;
        WorkInfo$State workInfo$State2 = new WorkInfo$State("RUNNING", 1);
        f2793b = workInfo$State2;
        WorkInfo$State workInfo$State3 = new WorkInfo$State("SUCCEEDED", 2);
        f2794c = workInfo$State3;
        WorkInfo$State workInfo$State4 = new WorkInfo$State("FAILED", 3);
        f2795d = workInfo$State4;
        WorkInfo$State workInfo$State5 = new WorkInfo$State("BLOCKED", 4);
        f2796e = workInfo$State5;
        WorkInfo$State workInfo$State6 = new WorkInfo$State("CANCELLED", 5);
        h = workInfo$State6;
        f2797j = new WorkInfo$State[]{workInfo$State, workInfo$State2, workInfo$State3, workInfo$State4, workInfo$State5, workInfo$State6};
    }

    public WorkInfo$State() {
        throw null;
    }

    public static WorkInfo$State valueOf(String str) {
        return (WorkInfo$State) Enum.valueOf(WorkInfo$State.class, str);
    }

    public static WorkInfo$State[] values() {
        return (WorkInfo$State[]) f2797j.clone();
    }

    public final boolean a() {
        return this == f2794c || this == f2795d || this == h;
    }
}
