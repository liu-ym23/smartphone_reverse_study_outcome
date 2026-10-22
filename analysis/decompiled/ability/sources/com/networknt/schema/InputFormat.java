package com.networknt.schema;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class InputFormat {

    /* renamed from: a, reason: collision with root package name */
    public static final InputFormat f3011a;
    public static final InputFormat b;
    public static final /* synthetic */ InputFormat[] c;

    static {
        InputFormat inputFormat = new InputFormat(JsonFactory.FORMAT_NAME_JSON, 0);
        f3011a = inputFormat;
        InputFormat inputFormat2 = new InputFormat(YAMLFactory.FORMAT_NAME_YAML, 1);
        b = inputFormat2;
        c = new InputFormat[]{inputFormat, inputFormat2};
    }

    public static InputFormat valueOf(String str) {
        return (InputFormat) Enum.valueOf(InputFormat.class, str);
    }

    public static InputFormat[] values() {
        return (InputFormat[]) c.clone();
    }
}
