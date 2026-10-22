package org.yaml.snakeyaml;

import org.json.HTTP;

/* loaded from: classes4.dex */
public enum DumperOptions$LineBreak {
    /* JADX INFO: Fake field, exist only in values array */
    WIN(HTTP.CRLF),
    /* JADX INFO: Fake field, exist only in values array */
    MAC("\r"),
    UNIX("\n");


    /* renamed from: a, reason: collision with root package name */
    public final String f5519a;

    DumperOptions$LineBreak(String str) {
        this.f5519a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Line break: " + name();
    }
}
