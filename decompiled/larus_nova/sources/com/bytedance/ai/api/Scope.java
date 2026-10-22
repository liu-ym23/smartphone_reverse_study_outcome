package com.bytedance.ai.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/api/Scope;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "userLocation", "userFuzzyLocation", "userLocationBackground", "payment", "record", "bluetooth", "camera", "addPhoneContact", "addPhoneCalendar", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Scope extends Enum<Scope> {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f33980a = null;
    public static final Scope addPhoneCalendar = null;
    public static final Scope addPhoneContact = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ Scope[] f33981b = null;
    public static final Scope bluetooth = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f33982c = null;
    public static final Scope camera = null;
    public static final Scope payment = null;
    public static final Scope record = null;
    public static final Scope userFuzzyLocation = null;
    public static final Scope userLocation = null;
    public static final Scope userLocationBackground = null;
    private final String value;

    public static EnumEntries<Scope> getEntries() {
        return f33982c;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.ai.api.Scope$a] */
    static {
        Scope r100 = new Scope("userLocation", 0, "scope.userLocation");
        userLocation = r100;
        Scope r101 = new Scope("userFuzzyLocation", 1, "scope.userFuzzyLocation");
        userFuzzyLocation = r101;
        Scope r102 = new Scope("userLocationBackground", 2, "scope.userLocationBackground");
        userLocationBackground = r102;
        Scope r103 = new Scope("payment", 3, "scope.payment");
        payment = r103;
        Scope r104 = new Scope("record", 4, "scope.record");
        record = r104;
        Scope r105 = new Scope("bluetooth", 5, "scope.bluetooth");
        bluetooth = r105;
        Scope r110 = new Scope("camera", 6, "scope.camera");
        camera = r110;
        Scope r111 = new Scope("addPhoneContact", 7, "scope.addPhoneContact");
        addPhoneContact = r111;
        Scope r112 = new Scope("addPhoneCalendar", 8, "scope.addPhoneCalendar");
        addPhoneCalendar = r112;
        Scope[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f33981b = r113;
        f33982c = EnumEntriesKt.enumEntries(r113);
        Companion = new a();
        EnumEntries<Scope> r106 = getEntries();
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<Scope> r108 = r106.iterator();
    L4:
        if (r108.hasNext() == false) goto L6;
        r107.add(r108.next().value);
        goto L4
    L6:
        f33980a = CollectionsKt.toSet(r107);
    }

    public static Scope[] values() {
        return (Scope[]) f33981b.clone();
    }

    public static final /* synthetic */ Set access$getVALUES$cp() {
        return f33980a;
    }

    public final String getValue() {
        return this.value;
    }

    public static Scope valueOf(String r100) {
        return (Scope) r27.a.a(Scope.class, r100);
    }

    public Scope(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
