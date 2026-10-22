package com.google.gson;

import d5.b;
import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class FieldNamingPolicy implements b {

    /* renamed from: a, reason: collision with root package name */
    public static final FieldNamingPolicy f5425a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ FieldNamingPolicy[] f5426b;

    static {
        FieldNamingPolicy fieldNamingPolicy = new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.1
            @Override // d5.b
            public final String a(Field field) {
                return field.getName();
            }
        };
        f5425a = fieldNamingPolicy;
        f5426b = new FieldNamingPolicy[]{fieldNamingPolicy, new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.2
            @Override // d5.b
            public final String a(Field field) {
                return FieldNamingPolicy.c(field.getName());
            }
        }, new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.3
            @Override // d5.b
            public final String a(Field field) {
                return FieldNamingPolicy.c(FieldNamingPolicy.b(field.getName(), ' '));
            }
        }, new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.4
            @Override // d5.b
            public final String a(Field field) {
                return FieldNamingPolicy.b(field.getName(), '_').toUpperCase(Locale.ENGLISH);
            }
        }, new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.5
            @Override // d5.b
            public final String a(Field field) {
                return FieldNamingPolicy.b(field.getName(), '_').toLowerCase(Locale.ENGLISH);
            }
        }, new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.6
            @Override // d5.b
            public final String a(Field field) {
                return FieldNamingPolicy.b(field.getName(), '-').toLowerCase(Locale.ENGLISH);
            }
        }, new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.7
            @Override // d5.b
            public final String a(Field field) {
                return FieldNamingPolicy.b(field.getName(), '.').toLowerCase(Locale.ENGLISH);
            }
        }};
    }

    public FieldNamingPolicy() {
        throw null;
    }

    public static String b(String str, char c9) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (Character.isUpperCase(cCharAt) && sb2.length() != 0) {
                sb2.append(c9);
            }
            sb2.append(cCharAt);
        }
        return sb2.toString();
    }

    public static String c(String str) {
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            char cCharAt = str.charAt(i10);
            if (!Character.isLetter(cCharAt)) {
                i10++;
            } else if (!Character.isUpperCase(cCharAt)) {
                char upperCase = Character.toUpperCase(cCharAt);
                if (i10 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i10) + upperCase + str.substring(i10 + 1);
            }
        }
        return str;
    }

    public static FieldNamingPolicy valueOf(String str) {
        return (FieldNamingPolicy) Enum.valueOf(FieldNamingPolicy.class, str);
    }

    public static FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[]) f5426b.clone();
    }
}
