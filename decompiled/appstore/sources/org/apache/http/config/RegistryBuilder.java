package org.apache.http.config;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public final class RegistryBuilder<I> {
    private final Map<String, I> items;

    public RegistryBuilder() {
        this.items = new HashMap();
    }

    public static <I> RegistryBuilder<I> create() {
        return new RegistryBuilder();
    }

    public Registry<I> build() {
        return new Registry(this.items);
    }

    public RegistryBuilder<I> register(String r10, I r11) {
        Args.notEmpty(r10, "ID");
        Args.notNull(r11, "Item");
        this.items.put(r10.toLowerCase(Locale.ROOT), r11);
        return this;
    }

    public String toString() {
        return this.items.toString();
    }
}
