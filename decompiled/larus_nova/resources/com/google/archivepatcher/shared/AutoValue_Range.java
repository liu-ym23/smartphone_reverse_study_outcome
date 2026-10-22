

package com.google.archivepatcher.shared;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_Range extends Range {

  private final long offset;

  private final long length;

  AutoValue_Range(
      long offset,
      long length) {
    this.offset = offset;
    this.length = length;
  }

  @Override
  public long offset() {
    return offset;
  }

  @Override
  public long length() {
    return length;
  }

  @Override
  public String toString() {
    return "Range{"
         + "offset=" + offset + ", "
         + "length=" + length
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Range) {
      Range that = (Range) o;
      return (this.offset == that.offset())
           && (this.length == that.length());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= (int) ((offset >>> 32) ^ offset);
    h$ *= 1000003;
    h$ ^= (int) ((length >>> 32) ^ length);
    return h$;
  }

}
