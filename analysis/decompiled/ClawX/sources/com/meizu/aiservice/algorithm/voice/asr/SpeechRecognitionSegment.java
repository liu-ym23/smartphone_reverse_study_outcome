package com.meizu.aiservice.algorithm.voice.asr;

import android.os.Parcel;
import android.os.Parcelable;
import b.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@a
/* loaded from: classes.dex */
public class SpeechRecognitionSegment implements Parcelable {
    public static final Parcelable.Creator<SpeechRecognitionSegment> CREATOR = new a3.a(14);
    private long end;
    private String sentence;
    private long start;

    public SpeechRecognitionSegment() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getEnd() {
        return this.end;
    }

    public String getSentence() {
        return this.sentence;
    }

    public long getStart() {
        return this.start;
    }

    public void setEnd(long j4) {
        this.end = j4;
    }

    public void setSentence(String str) {
        this.sentence = str;
    }

    public void setStart(long j4) {
        this.start = j4;
    }

    public String toString() {
        return "[" + this.start + " --> " + this.end + "]:" + this.sentence;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeLong(this.start);
        parcel.writeLong(this.end);
        parcel.writeString(this.sentence);
    }

    public SpeechRecognitionSegment(long j4, long j8, String str) {
        this.start = j4;
        this.end = j8;
        this.sentence = str;
    }

    public SpeechRecognitionSegment(Parcel parcel) {
        this.start = parcel.readLong();
        this.end = parcel.readLong();
        this.sentence = parcel.readString();
    }
}
