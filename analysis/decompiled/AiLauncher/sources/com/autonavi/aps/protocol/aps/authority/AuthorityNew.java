package com.autonavi.aps.protocol.aps.authority;

import java.io.Serializable;
import java.sql.Timestamp;

/* loaded from: classes.dex */
public class AuthorityNew implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private Integer f18477a;

    /* renamed from: b, reason: collision with root package name */
    private String f18478b;

    /* renamed from: c, reason: collision with root package name */
    private String f18479c;

    /* renamed from: d, reason: collision with root package name */
    private String f18480d;

    /* renamed from: e, reason: collision with root package name */
    private String f18481e;

    /* renamed from: f, reason: collision with root package name */
    private String f18482f;

    /* renamed from: g, reason: collision with root package name */
    private String f18483g;

    /* renamed from: h, reason: collision with root package name */
    private String f18484h;

    /* renamed from: i, reason: collision with root package name */
    private Timestamp f18485i;

    /* renamed from: j, reason: collision with root package name */
    private Timestamp f18486j;

    /* renamed from: k, reason: collision with root package name */
    private String f18487k;

    /* renamed from: l, reason: collision with root package name */
    private String f18488l;

    public AuthorityNew() {
    }

    public String getControltype() {
        return this.f18484h;
    }

    public String getDesc() {
        return this.f18487k;
    }

    public String getFormtype() {
        return this.f18482f;
    }

    public String getHeaders() {
        return this.f18488l;
    }

    public Integer getId() {
        return this.f18477a;
    }

    public String getLicense() {
        return this.f18479c;
    }

    public Timestamp getLogtime() {
        return this.f18486j;
    }

    public String getSeckey() {
        return this.f18480d;
    }

    public String getServicetype() {
        return this.f18483g;
    }

    public String getSrc() {
        return this.f18478b;
    }

    public String getType() {
        return this.f18481e;
    }

    public Timestamp getValidtime() {
        return this.f18485i;
    }

    public void setControltype(String str) {
        this.f18484h = str;
    }

    public void setDesc(String str) {
        this.f18487k = str;
    }

    public void setFormtype(String str) {
        this.f18482f = str;
    }

    public void setHeaders(String str) {
        this.f18488l = str;
    }

    public void setId(Integer num) {
        this.f18477a = num;
    }

    public void setLicense(String str) {
        this.f18479c = str;
    }

    public void setLogtime(Timestamp timestamp) {
        this.f18486j = timestamp;
    }

    public void setSeckey(String str) {
        this.f18480d = str;
    }

    public void setServicetype(String str) {
        this.f18483g = str;
    }

    public void setSrc(String str) {
        this.f18478b = str;
    }

    public void setType(String str) {
        this.f18481e = str;
    }

    public void setValidtime(Timestamp timestamp) {
        this.f18485i = timestamp;
    }

    public AuthorityNew(String str, String str2, String str3, String str4, String str5, Timestamp timestamp, Timestamp timestamp2) {
        this.f18478b = str;
        this.f18479c = str2;
        this.f18481e = str3;
        this.f18482f = str4;
        this.f18483g = str5;
        this.f18485i = timestamp;
        this.f18486j = timestamp2;
    }

    public AuthorityNew(String str, String str2, String str3, String str4, String str5, String str6, String str7, Timestamp timestamp, Timestamp timestamp2, String str8) {
        this.f18478b = str;
        this.f18479c = str2;
        this.f18480d = str3;
        this.f18481e = str4;
        this.f18482f = str5;
        this.f18483g = str6;
        this.f18484h = str7;
        this.f18485i = timestamp;
        this.f18486j = timestamp2;
        this.f18487k = str8;
    }
}
