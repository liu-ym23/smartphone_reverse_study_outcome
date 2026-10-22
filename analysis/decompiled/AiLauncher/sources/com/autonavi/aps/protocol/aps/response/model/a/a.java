package com.autonavi.aps.protocol.aps.response.model.a;

import com.autonavi.aps.protocol.aps.common.enums.Status;
import com.autonavi.aps.protocol.aps.common.enums.Version;
import com.autonavi.aps.protocol.aps.response.model.b.a;
import com.autonavi.aps.protocol.aps.response.model.vo.fields.Semantics;
import com.autonavi.aps.protocol.aps.response.model.vo.fields.b;
import com.autonavi.aps.protocol.aps.response.model.vo.fields.c;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Status f19086a = Status.SUCCESS;

    /* renamed from: b, reason: collision with root package name */
    private a.C0216a f19087b = new a.C0216a();

    /* renamed from: c, reason: collision with root package name */
    private boolean f19088c;

    /* renamed from: d, reason: collision with root package name */
    private c f19089d;

    /* renamed from: e, reason: collision with root package name */
    private String f19090e;

    /* renamed from: f, reason: collision with root package name */
    private List<b> f19091f;

    /* renamed from: g, reason: collision with root package name */
    private String f19092g;

    /* renamed from: h, reason: collision with root package name */
    private String f19093h;

    /* renamed from: i, reason: collision with root package name */
    private byte[] f19094i;

    /* renamed from: j, reason: collision with root package name */
    private short f19095j;

    /* renamed from: k, reason: collision with root package name */
    private Byte f19096k;

    /* renamed from: l, reason: collision with root package name */
    private List<Semantics> f19097l;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f19098m;

    public a() {
        new com.autonavi.aps.protocol.aps.request.model.fields.b();
        this.f19088c = true;
        this.f19089d = null;
        this.f19090e = null;
        this.f19091f = null;
        this.f19092g = null;
        this.f19093h = null;
        this.f19094i = null;
        this.f19095j = (short) -1;
        this.f19096k = null;
        this.f19097l = null;
        this.f19098m = null;
    }

    public void a(Version version) {
    }

    public a.C0216a b() {
        return this.f19087b;
    }

    public boolean c() {
        return false;
    }

    public byte[] d() {
        return this.f19094i;
    }

    public boolean e() {
        return this.f19088c;
    }

    public c f() {
        return this.f19089d;
    }

    public List<b> g() {
        return this.f19091f;
    }

    public String h() {
        return this.f19090e;
    }

    public String i() {
        return null;
    }

    public String j() {
        return this.f19092g;
    }

    public String k() {
        return this.f19093h;
    }

    public short l() {
        return this.f19095j;
    }

    public Byte m() {
        return this.f19096k;
    }

    public List<Semantics> n() {
        return this.f19097l;
    }

    public byte[] o() {
        return this.f19098m;
    }

    public Status a() {
        return this.f19086a;
    }

    public void b(String str) {
        this.f19092g = str;
    }

    public void c(String str) {
        this.f19093h = str;
    }

    public void a(Status status) {
        this.f19086a = status;
    }

    public void b(Byte b10) {
        this.f19087b.a(b10);
    }

    public void a(a.C0216a c0216a) {
        this.f19087b = c0216a;
    }

    public void b(List<Semantics> list) {
        this.f19097l = list;
    }

    public void a(byte[] bArr) {
        this.f19094i = bArr;
    }

    public void b(byte[] bArr) {
        this.f19098m = bArr;
    }

    public void a(boolean z10) {
        this.f19088c = z10;
    }

    public void a(c cVar) {
        this.f19089d = cVar;
    }

    public void a(List<b> list) {
        this.f19091f = list;
    }

    public void a(String str) {
        this.f19090e = str;
    }

    public void a(short s10) {
        this.f19095j = s10;
    }

    public void a(Byte b10) {
        this.f19096k = b10;
    }

    public void a(Short sh) {
        this.f19087b.a(sh);
    }
}
