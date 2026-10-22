package com.bytedance.frameworks.baselib.network.http.impl;

import android.util.Log;
import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.http.HttpHost;
import r4.c;

/* JADX INFO: loaded from: classes.dex */
public class SerializableHttpCookie implements Serializable {
    private static final String TAG = "SerializableHttpCookie";
    private static final long serialVersionUID = 6374381323722046732L;
    private transient c cookie;
    private long whenCreated;

    static {
    }

    public SerializableHttpCookie(c r10) {
        this.cookie = r10;
        this.whenCreated = System.currentTimeMillis();
    }

    private String byteArrayToHexString(byte[] r10) {
        StringBuilder r11 = new StringBuilder(r10.length * 2);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        int r14 = r10[r13] & UnsignedBytes.MAX_VALUE;
        if (r14 >= 16) goto L7;
        r11.append('0');
    L7:
        r11.append(Integer.toHexString(r14));
        r13 = r13 + 1;
        goto L3
    L9:
        return r11.toString();
    }

    public static SerializableHttpCookie decode(String r10) {
        return (SerializableHttpCookie) new ObjectInputStream(new ByteArrayInputStream(hexStringToByteArray(r10))).readObject();
    L7:
        e = move-exception;
        Log.d(TAG, "IOException in decodeCookie", e);
        return null;
    L5:
        e = move-exception;
        Log.d(TAG, "ClassNotFoundException in decodeCookie", e);
        return null;
    }

    public static int getEffectivePort(String r10, int r11) {
        if (r11 == (-1)) goto L6;
        return r11;
    L6:
        if (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(r10) == false) goto L10;
        return 80;
    L10:
        if ("https".equalsIgnoreCase(r10) == false) goto L13;
        return 443;
    L13:
        return -1;
    }

    private boolean getHttpOnly() {
        return this.cookie.y();
    }

    private static byte[] hexStringToByteArray(String r10) {
        int r11 = r10.length();
        byte[] r12 = new byte[r11 / 2];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12[r13 / 2] = (byte) ((Character.digit(r10.charAt(r13), 16) << 4) + Character.digit(r10.charAt(r13 + 1), 16));
        r13 = r13 + 2;
        goto L3
    L5:
        return r12;
    }

    private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
        c r11 = new c((String) r10.readObject(), (String) r10.readObject());
        this.cookie = r11;
        r11.Q((String) r10.readObject());
        this.cookie.R((String) r10.readObject());
        this.cookie.T((String) r10.readObject());
        this.cookie.W(r10.readLong());
        this.cookie.X((String) r10.readObject());
        this.cookie.Y((String) r10.readObject());
        this.cookie.a0(r10.readInt());
        this.cookie.Z(r10.readBoolean());
        this.cookie.S(r10.readBoolean());
        setHttpOnly(r10.readBoolean());
        this.whenCreated = r10.readLong();
    }

    private void setHttpOnly(boolean r10) {
        this.cookie.V(r10);
    }

    private void writeObject(ObjectOutputStream r10) throws IOException {
        r10.writeObject(this.cookie.A());
        r10.writeObject(this.cookie.E());
        r10.writeObject(this.cookie.u());
        r10.writeObject(this.cookie.v());
        r10.writeObject(this.cookie.x());
        r10.writeLong(this.cookie.z());
        r10.writeObject(this.cookie.B());
        r10.writeObject(this.cookie.C());
        r10.writeInt(this.cookie.F());
        r10.writeBoolean(this.cookie.D());
        r10.writeBoolean(this.cookie.w());
        r10.writeBoolean(getHttpOnly());
        r10.writeLong(this.whenCreated);
    }

    public String encode() {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        new ObjectOutputStream(r10).writeObject(this);     // Catch: IOException -> L6
        return byteArrayToHexString(r10.toByteArray());
    L6:
        e = move-exception;
        Log.d(TAG, "IOException in encodeCookie", e);
        return null;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof c) == false) goto L7;
        return this.cookie.equals(r10);
    L7:
        if ((r10 instanceof SerializableHttpCookie) == true) goto L9;
        return false;
    L9:
        return this.cookie.equals(((SerializableHttpCookie) r10).cookie);
    }

    public c getHttpCookie() {
        return this.cookie;
    }

    public Long getWhenCreated() {
        return Long.valueOf(this.whenCreated);
    }

    public boolean hasExpired() {
        long r10 = this.cookie.z();
        if (r10 != (-1)) goto L6;
        return false;
    L6:
        if (((System.currentTimeMillis() - this.whenCreated) / 1000) <= r10) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        return this.cookie.hashCode();
    }
}
