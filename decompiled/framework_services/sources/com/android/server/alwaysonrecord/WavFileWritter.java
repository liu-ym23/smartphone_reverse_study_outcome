package com.android.server.alwaysonrecord;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes.dex */
public class WavFileWritter {
    private static final String TAG = null;
    private FileOutputStream mFos;

    static {
        TAG = WavFileWritter.class.getSimpleName();
    }

    public WavFileWritter(File file, int dataSize, int sampleRate, int numChannels, int bitsPerSample) throws IOException {
        this.mFos = new FileOutputStream(file);
        writeWavHeader(dataSize, sampleRate, numChannels, bitsPerSample);
    }

    public void write(ByteBuffer buffer) throws IOException {
        FileChannel fileChannel = this.mFos.getChannel();
        fileChannel.write(buffer);
    }

    public void close() {
        this.mFos.flush();     // Catch: IOException -> L4
        this.mFos.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        Log.w(TAG, "Failed to close file stream");
    }

    private void writeWavHeader(int dataSize, int sampleRate, int numChannels, int bitsPerSample) throws IOException {
        int blockAlign = (numChannels * bitsPerSample) / 8;
        int byteRate = sampleRate * blockAlign;
        this.mFos.write("RIFF".getBytes());
        writeIntAsLittleEndianBytes(dataSize + 36);
        this.mFos.write("WAVE".getBytes());
        this.mFos.write("fmt ".getBytes());
        writeIntAsLittleEndianBytes(16);
        writeShortAsLittleEndianBytes(1);
        writeShortAsLittleEndianBytes((short) numChannels);
        writeIntAsLittleEndianBytes(sampleRate);
        writeIntAsLittleEndianBytes(byteRate);
        writeShortAsLittleEndianBytes((short) blockAlign);
        writeShortAsLittleEndianBytes((short) bitsPerSample);
        this.mFos.write("data".getBytes());
        writeIntAsLittleEndianBytes(dataSize);
        this.mFos.flush();
    }

    private void writeIntAsLittleEndianBytes(int value) throws IOException {
        this.mFos.write(value & 255);
        this.mFos.write((value >> 8) & 255);
        this.mFos.write((value >> 16) & 255);
        this.mFos.write((value >> 24) & 255);
    }

    private void writeShortAsLittleEndianBytes(short value) throws IOException {
        this.mFos.write(value & 255);
        this.mFos.write((value >> 8) & 255);
    }
}
