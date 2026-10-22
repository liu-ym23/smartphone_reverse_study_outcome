package io.noties.markwon.core;

import u8.p;

/* loaded from: classes4.dex */
public abstract class CoreProps {

    /* renamed from: a, reason: collision with root package name */
    public static final p<ListItemType> f34200a = p.c("list-item-type");

    /* renamed from: b, reason: collision with root package name */
    public static final p<Integer> f34201b = p.c("bullet-list-item-level");

    /* renamed from: c, reason: collision with root package name */
    public static final p<Integer> f34202c = p.c("ordered-list-item-number");

    /* renamed from: d, reason: collision with root package name */
    public static final p<Integer> f34203d = p.c("heading-level");

    /* renamed from: e, reason: collision with root package name */
    public static final p<String> f34204e = p.c("link-destination");

    /* renamed from: f, reason: collision with root package name */
    public static final p<Boolean> f34205f = p.c("paragraph-is-in-tight-list");

    /* renamed from: g, reason: collision with root package name */
    public static final p<String> f34206g = p.c("code-block-info");

    public enum ListItemType {
        BULLET,
        ORDERED
    }
}
