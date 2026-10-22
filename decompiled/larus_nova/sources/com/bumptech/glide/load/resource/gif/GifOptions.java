package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Option;

/* JADX INFO: loaded from: classes39.dex */
public final class GifOptions {
    public static final Option<DecodeFormat> DECODE_FORMAT = null;
    public static final Option<Integer> FILE_SIZE = null;
    public static final Option<Integer> MAX_HEIGHT = null;
    public static final Option<Integer> MAX_WIDTH = null;

    static {
        DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.gif.GifOptions.DecodeFormat", DecodeFormat.DEFAULT);
        FILE_SIZE = Option.memory("com.bumptech.glide.load.resource.gif.GifOptions.FILE_SIZE", 0);
        MAX_WIDTH = Option.memory("com.bumptech.glide.load.resource.gif.GifOptions.MAX_WIDTH", 0);
        MAX_HEIGHT = Option.memory("com.bumptech.glide.load.resource.gif.GifOptions.MAX_HEIGHT", 0);
    }

    private GifOptions() {
    }
}
