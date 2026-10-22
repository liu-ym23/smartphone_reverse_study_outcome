package com.android.contacts;

import android.net.Uri;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class PhoneCallDetails {
    public int blockedType;
    public final int[] callTypes;
    public final Uri contactUri;
    public final String countryIso;
    public final long date;
    public final long duration;
    public final CharSequence formattedNumber;
    public final String geocode;
    public boolean isVideoCall;
    public final CharSequence name;
    public final CharSequence number;
    public final CharSequence numberLabel;
    public final int numberType;
    public final long photoId;
    public final Uri photoUri;
    public final int presentation;
    public String recordUri;
    public boolean showSimId;
    public int simId;
    public int subScription;

    public PhoneCallDetails(CharSequence r20, int[] r21, long r22, long r24, Uri r26, String r27) {
        this(r20, "", "", "", r21, r22, r24, "", -1, "", r26, null, -1, -1, r27);
    }

    public PhoneCallDetails(CharSequence r4, CharSequence r5, String r6, String r7, int[] r8, long r9, long r11, CharSequence r13, int r14, CharSequence r15, Uri r16, Uri r17, long r18, int r20, String r21) {
        this.simId = -1;
        this.subScription = -1;
        this.number = r4;
        this.formattedNumber = r5;
        this.countryIso = r6;
        this.geocode = r7;
        this.callTypes = r8;
        this.date = r9;
        this.duration = r11;
        this.name = r13;
        this.numberType = r14;
        this.numberLabel = r15;
        this.contactUri = r16;
        this.photoUri = r17;
        this.presentation = r20;
        this.photoId = r18;
        this.recordUri = r21;
    }

    public String toString() {
        return "number = " + this.number + ", formattedNumber = " + this.formattedNumber + ", countryIso = " + this.countryIso + ", geocode = " + this.geocode + ", callTypes = " + Arrays.toString(this.callTypes) + ", date = " + this.date + ", duration = " + this.duration + ", name = " + this.name + ", numberType = " + this.numberType + ", numberLabel = " + this.numberLabel + ", contactUri = " + this.contactUri + ", photoUri = " + this.photoUri + ", photoId = " + this.photoId + ", presentation = " + this.presentation + ", recordUri = " + this.recordUri;
    }
}
