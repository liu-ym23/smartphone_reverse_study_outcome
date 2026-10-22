package org.yaml.snakeyaml.events;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class Event$ID {

    /* renamed from: a, reason: collision with root package name */
    public static final Event$ID f5525a;
    public static final Event$ID b;
    public static final Event$ID c;
    public static final Event$ID d;
    public static final Event$ID e;
    public static final Event$ID f;
    public static final Event$ID g;
    public static final Event$ID h;
    public static final Event$ID i;

    /* renamed from: j, reason: collision with root package name */
    public static final Event$ID f5526j;
    public static final Event$ID k;
    public static final /* synthetic */ Event$ID[] l;

    static {
        Event$ID event$ID = new Event$ID("Alias", 0);
        f5525a = event$ID;
        Event$ID event$ID2 = new Event$ID("Comment", 1);
        b = event$ID2;
        Event$ID event$ID3 = new Event$ID("DocumentEnd", 2);
        c = event$ID3;
        Event$ID event$ID4 = new Event$ID("DocumentStart", 3);
        d = event$ID4;
        Event$ID event$ID5 = new Event$ID("MappingEnd", 4);
        e = event$ID5;
        Event$ID event$ID6 = new Event$ID("MappingStart", 5);
        f = event$ID6;
        Event$ID event$ID7 = new Event$ID("Scalar", 6);
        g = event$ID7;
        Event$ID event$ID8 = new Event$ID("SequenceEnd", 7);
        h = event$ID8;
        Event$ID event$ID9 = new Event$ID("SequenceStart", 8);
        i = event$ID9;
        Event$ID event$ID10 = new Event$ID("StreamEnd", 9);
        f5526j = event$ID10;
        Event$ID event$ID11 = new Event$ID("StreamStart", 10);
        k = event$ID11;
        l = new Event$ID[]{event$ID, event$ID2, event$ID3, event$ID4, event$ID5, event$ID6, event$ID7, event$ID8, event$ID9, event$ID10, event$ID11};
    }

    public static Event$ID valueOf(String str) {
        return (Event$ID) Enum.valueOf(Event$ID.class, str);
    }

    public static Event$ID[] values() {
        return (Event$ID[]) l.clone();
    }
}
